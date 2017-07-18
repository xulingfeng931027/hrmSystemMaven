package paul.web.service;


import paul.domain.*;
import paul.utils.PageModel;

import java.util.List;

/**
 * Created by paul on 2017-07-07.
 */
public interface HrmService {

    /**
     * User的Service
     */
    //用户登录
    User login(String username, String password);

    //根据id差用户
    User findUserById(int id);

    //动态查询用户并分页显示
    List<User> findAllUser(User user, PageModel pageModel);

    //根据id删除用户
    void removeUserById(int id);

    //修改用户
    void modifyUserById(User user);

    //添加用户
    void addUser(User user);

    /**
     * Department的Service
     */
    //添加部门
    int addDepartment(Department department);

    //删除部门
    void removeDepartmentById(int id);

    //查找部门
    Department findDepartmentById(int id);

    //查看所有部门
    List<Department> findAllDepartment(Department department, PageModel pageModel);

    //修改部门信息
    void modifyDepartmentById(Department department);

    /**
     * Document的Service
     **/
    //添加文档
    void addDocument(Document Document);

    //删除文档
    void removeDocumentById(int id);

    //查找文档
    Document findDocumentById(int id);

    //查看所有文档
    List<Document> findAllDocument(Document document, PageModel pageModel);

    //修改文档信息
    void modifyDocumentById(Document Document);

    /**
     * Employee的Service
     **/
    //添加员工
    void addEmployee(Employee Employee);

    //删除员工
    void removeEmployeeById(int id);

    //查找员工
    Employee findEmployeeById(int id);

    //查看所有员工
    List<Employee> findAllEmployee(Employee employee, PageModel pageModel);

    //修改员工信息
    void modifyEmployeeById(Employee Employee);

    /**
     * Notice的Service
     **/
    //添加公告
    void addNotice(Notice Notice);

    //删除公告
    void removeNoticeById(int id);

    //查找公告
    Notice findNoticeById(int id);

    //查看所有公告
    List<Notice> findAllNotice(Notice notice, PageModel pageModel);

    //修改公告信息
    void modifyNoticeById(Notice Notice);

    /**
     * Job的Service
     **/
    //添加工作
    void addJob(Job Job);

    //删除工作
    void removeJobById(int id);

    //查找工作
    Job findJobById(int id);

    //查看所有工作
    List<Job> findAllJob(Job Job, PageModel pageModel);

    //修改工作信息
    void modifyJobById(Job Job);


}
