package paul.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import paul.domain.Department;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("dept")
public class DepartmentController {
    @Autowired
    private HrmService hrmService;

    public DepartmentController(HrmService hrmService) {
        this.hrmService = hrmService;
    }

    //添加部门
    @RequestMapping("/addDept")
    public String addDept(@ModelAttribute Department department, String flag) {
        if (flag.equals("1")) {
            return "dept/showAddDept";
        }
        hrmService.addDepartment(department);
        return "redirect:/dept/selectDept";
    }

    //查询部门
    @RequestMapping("selectDept")
    public String showDept(Model model, Integer pageIndex, @ModelAttribute Department department) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        List<Department> list = hrmService.findAllDepartment(department, pageModel);
        model.addAttribute("depts", list);
        model.addAttribute(pageModel);
        return "dept/dept";
    }

    //处理删除请求
    @RequestMapping("/removeDept")
    public String removeDept(String ids) {
        //分解字符串+
        String[] idArray = ids.split(",");
//        根据id删除即可
        for (String id : idArray) {
            hrmService.removeDepartmentById(Integer.parseInt(id));
        }
        return "redirect:/dept/selectDept";
    }

    //处理修改请求
    @RequestMapping("/updateDept")
    public String updateDept(@ModelAttribute Department dept, String flag) {
        if (flag.equals("1")) {
            return "dept/showUpdateDept";
        }
        hrmService.modifyDepartmentById(dept);
        return "redirect:/dept/selectDept";
    }
}
