package paul.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import paul.domain.Notice;
import paul.domain.User;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private HrmService hrmService;

    //添加文档
    @RequestMapping("/addNotice")
    public String addNotice(@ModelAttribute Notice notice, String flag, HttpSession session) {
        if (flag.equals("1")) {
            return "notice/showAddNotice";
        }
        User user = (User) session.getAttribute("user");
        notice.setUser(user);
        hrmService.addNotice(notice);
        return "redirect:/notice/selectNotice";
    }

    //查询公告
    @RequestMapping("/selectNotice")
    public String showNotice(Model model, Integer pageIndex, @ModelAttribute Notice Notice) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        List<Notice> list = hrmService.findAllNotice(Notice, pageModel);
        model.addAttribute("notices", list);
        model.addAttribute(pageModel);
        return "notice/notice";
    }

    //处理预览请求
    @RequestMapping("/previewNotice")
    public String showPreviewNotice(String id, Model model)

    {
         Notice notice = hrmService.findNoticeById(Integer.parseInt(id));
        model.addAttribute(notice);
        return "notice/previewNotice";
    }

    //处理删除请求
    @RequestMapping("/removeNotice")
    public String removeNotice(String ids) {
        //分解字符串
        String[] idArray = ids.split(",");
//        根据id删除即可
        for (String id : idArray) {
            hrmService.removeNoticeById(Integer.parseInt(id));
        }
        return "redirect:/notice/selectNotice";
    }

    //处理修改请求
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice Notice, String flag, String id, Model model) {
        if (flag.equals("1")) {

            Notice notice = hrmService.findNoticeById(Integer.parseInt(id));
            model.addAttribute(notice);
            return "notice/showUpdateNotice";
        }
        hrmService.modifyNoticeById(Notice);
        return "redirect:/notice/selectNotice";
    }
}
