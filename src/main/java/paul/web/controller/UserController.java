package paul.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import paul.domain.User;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
@Controller
public class UserController {
    @Autowired
    private HrmService hrmService;

    //处理登陆请求
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, RedirectAttributes model) {
        //调用登陆方法
        User user = hrmService.login(username, password);
        if (user != null) {
            //将用户保存到model中
            session.setAttribute("user", user);
            model.addFlashAttribute(user);
            return "redirect:/right.jsp";
        }
        //设置登陆失败信息
        model.addAttribute("message", "登录名或密码错误请重新登陆");
        return "forward:/WEB-INF/views/loginForm.jsp";

    }

    //处理查询请求
    @RequestMapping("/user/selectUser")
    public String selectUser(Integer pageIndex, User user, Model model) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        //查询用户信息
        List<User> users = hrmService.findAllUser(user, pageModel);
        model.addAttribute("users", users);
        model.addAttribute(pageModel);
        return "user/user";
    }

    //处理删除请求
    @RequestMapping("/user/removeUser")
    public String removeUser(String ids, Model model) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            hrmService.removeUserById(Integer.parseInt(id));
        }
        //设置跳转
        return "redirect:/user/selectUser";
    }

    @RequestMapping("/user/updateUser")
    public String updateUser(User user, String flag, Model model) {
        //flag的值:1表示跳转到修改页面,2表示执行修改操作
        if (flag.equals("1")) {
            User user1 = hrmService.findUserById(user.getId());
            model.addAttribute("user", user1);
            return "user/showUpdateUser";
        }
        hrmService.modifyUserById(user);
        return "redirect:/user/selectUser";
    }

    @RequestMapping("/user/addUser")
    public String addUser(String flag, User user, Model model) {
        if (flag.equals("1")) {
            return "user/showAddUser";
        }
        hrmService.addUser(user);
        return "redirect:/user/selectUser";
    }
}
