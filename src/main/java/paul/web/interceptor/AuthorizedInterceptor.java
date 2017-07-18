package paul.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import paul.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/7 0007.
 * 判断用户权限的Spring MVC拦截器
 */
public class AuthorizedInterceptor implements HandlerInterceptor {
    //定义不需要拦截的页面
    private static final String[] IGNORE_URL = {"/loginForm", "/login", "/404.html", "/top"};

    //这是用于拦截的主要方法,在Controller处理之前就调用,返回false时整个请求结束.
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法启动了");
        //默认用户未登录
        boolean flag = false;
        //获得请求的ServletPath
        String servletPath = request.getServletPath();
        //判断是否需要拦截
        for (String url : IGNORE_URL) {
            if (servletPath.contains(url)) {
                return true;
            }
            //否则就拦截请求
        }
        if (request.getSession() != null) {
            User user = (User) request.getSession().getAttribute("user");
            //如果未登录,就跳转
            if (user == null) {
                request.setAttribute("message", "请登陆后访问!");
                request.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request, response);
                System.out.println("用户未登录");
                return false;
            }
            return true;
        }
        return true;
    }

    //这个方法要在preHandle方法返回true后,整个请求完成前执行..
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法启动了");
    }

    //这个方法要在preHandle方法返回true后执行,在整个请求完成后执行,主要用于资源清理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterHandle方法启动了");
    }
}
