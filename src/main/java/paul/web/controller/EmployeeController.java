package paul.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import paul.domain.Department;
import paul.domain.Employee;
import paul.domain.Job;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private HrmService hrmService;

    //添加员工
    @RequestMapping("addEmployee")
    public String addEmployee(@ModelAttribute Employee employee, String flag, HttpServletRequest request) {
        if (flag.equals("1")) {
            List<Department> depts = hrmService.findAllDepartment(null, null);
            List<Job> jobs = hrmService.findAllJob(null, null);
            request.setAttribute("jobs", jobs);
            request.setAttribute("depts", depts);
            return "employee/showAddEmployee";
        }

        hrmService.addEmployee(employee);
        return "redirect:/employee/selectEmployee";
    }

    //查询部门
    @RequestMapping("selectEmployee")
    public String showEmployee(Model model, Integer pageIndex, @ModelAttribute Employee employee) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        List<Employee> list = hrmService.findAllEmployee(employee, pageModel);
        model.addAttribute("employees", list);
        model.addAttribute(pageModel);
        return "employee/employee";
    }

    //处理删除请求
    @RequestMapping("/removeEmployee")
    public String removeEmployee(String ids) {
        //分解字符串
        String[] idArray = ids.split(",");
//        根据id删除即可
        for (String id : idArray) {
            hrmService.removeEmployeeById(Integer.parseInt(id));
        }
        return "redirect:/employee/selectEmployee";
    }

    //处理修改请求
    @RequestMapping("/updateEmployee")
    public String updateemployee(@ModelAttribute Employee employee, String flag) {
        if (flag.equals("1")) {
            return "employee/showUpdateEmployee";
        }
        hrmService.modifyEmployeeById(employee);
        return "redirect:/employee/selectEmployee";
    }
}
