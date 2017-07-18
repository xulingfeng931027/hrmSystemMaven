package paul.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import paul.domain.Job;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private HrmService hrmService;

    //添加职位
    @RequestMapping("/addJob")
    public String addJob(@ModelAttribute Job job, String flag) {
        if (flag.equals("1")) {
            return "job/showAddJob";
        }
        hrmService.addJob(job);
        return "redirect:/job/selectJob";
    }

    //查询职位
    @RequestMapping("selectJob")
    public String showJob(Model model, Integer pageIndex, @ModelAttribute Job Job) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        //执行查询请求
        List<Job> list = hrmService.findAllJob(Job, pageModel);
        model.addAttribute("jobs", list);
        model.addAttribute(pageModel);
        return "job/job";
    }

    //处理删除请求
    @RequestMapping("/removeJob")
    public String removeJob(String ids) {
        //分解字符串
        String[] idArray = ids.split(",");
//        根据id删除即可
        for (String id : idArray) {
            hrmService.removeJobById(Integer.parseInt(id));
        }
        return "redirect:/job/selectJob";
    }

    //处理修改请求
    @RequestMapping("/updateJob")
    public String updateJob(@ModelAttribute Job Job, String flag) {
        if (flag.equals("1")) {
            return "job/showUpdateJob";
        }
        hrmService.modifyJobById(Job);
        return "redirect:/job/selectJob";
    }
}

