package paul.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class HrmSystemInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }

    //将额外的Filter注册到DispatcherServlet中
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMVCConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        //将DispatcherServlet映射到"/"
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        File file = new File("C/Users/Administrator/.IntelliJIdea2017.1/system/tomcat/未命名_hrmSystem/work/Catalina/localhost/ROOT/temp/upload");
//        if(!file.exists()){
//            file.mkdirs();
//        }
        registration.setMultipartConfig(new MultipartConfigElement
                ("/", 2000000, 4000000, 0));
    }

}
