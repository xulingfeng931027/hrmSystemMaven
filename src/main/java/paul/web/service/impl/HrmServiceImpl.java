package paul.web.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import paul.dao.*;
import paul.domain.*;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017-07-07.
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service
public class HrmServiceImpl implements HrmService {
    @Autowired
    private UserDao userDao;
    /**
     * Department的Service
     *
     * @param department
     */
    @Autowired
    private DepartmentDao departmentDao;
    /**
     * Document的Service
     *
     * @param Document
     */
    @Autowired
    private DocumentDao documentDao;
    /**
     * Employee的Service
     *
     * @param Employee
     */
    @Autowired
    private EmployeeDao employeeDao;
    /**
     * Notice的Service
     *
     * @param Notice
     */
    @Autowired
    private NoticeDao noticeDao;
    /**
     * Job的Service
     *
     * @param Job
     */
    @Autowired
    private JobDao jobDao;

    /**
     * @see {HrmService}
     * 用户服务接口实现
     */
    @Transactional(readOnly = true)
    
    public User login(String username, String password) {
        return userDao.selectByUsernameAndPassword(username, password);
    }

    @Transactional(readOnly = true)
    
    public User findUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public List<User> findAllUser(User user, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap();
        params.put("user", user);
        int recordCount = userDao.selectCount(user);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始分页查询,查询第几页
            params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectWithParam(params);
        return users;
    }

    
    public void removeUserById(int id) {
        userDao.deleteById(id);
    }

    
    public void modifyUserById(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    
    public void addUser(User user) {
        userDao.insertSelective(user);
    }

    
    public int addDepartment(Department department) {
        return departmentDao.insertSelective(department);
    }

    
    public void removeDepartmentById(int id) {
        departmentDao.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public Department findDepartmentById(int id) {
        return departmentDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public List<Department> findAllDepartment(Department department, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("dept", department);
        int recordCount = departmentDao.selectCount(department);
        if (pageModel != null) {
            pageModel.setRecordCount(recordCount);
        }
        if (recordCount > 0) {
            //开始分页查询
            params.put("pageModel", pageModel);
        }
        return departmentDao.selectWithParam(params);
    }

    

    public void modifyDepartmentById(Department department) {
        departmentDao.updateByPrimaryKey(department);
    }


    //文档接口

    
    public void addDocument(Document document) {
        documentDao.insertSelective(document);
    }

    
    public void removeDocumentById(int id) {
        documentDao.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public Document findDocumentById(int id) {
        return documentDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public List<Document> findAllDocument(Document document, PageModel pageModel) {
        Map<String, Object> param = new HashMap<>();
        int recordCount = documentDao.selectCount(document);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            param.put("pageModel", pageModel);
        }
        param.put("document", document);
        return documentDao.selectWithParam(param);
    }

    
    public void modifyDocumentById(Document document) {
        documentDao.updateByPrimaryKeySelective(document);
    }

    //员工接口
    
    public void addEmployee(Employee employee) {
        employeeDao.insertSelective(employee);
    }

    
    public void removeEmployeeById(int id) {
        employeeDao.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public Employee findEmployeeById(int id) {
        return null;
    }

    @Transactional(readOnly = true)
    
    public List<Employee> findAllEmployee(Employee employee, PageModel pageModel) {
        Map<String, Object> param = new HashMap<>();
        int recordCount = employeeDao.selectCount(employee);
        if (recordCount > 0) {
            pageModel.setRecordCount(recordCount);
        }
        param.put("employee", employee);
        param.put("pageModel", pageModel);
        return employeeDao.selectWithParam(param);
    }

    
    public void modifyEmployeeById(Employee employee) {
        employeeDao.updateByPrimaryKeySelective(employee);
    }

    //公告接口

    
    public void addNotice(Notice notice) {
        noticeDao.insertSelective(notice);
    }

    
    public void removeNoticeById(int id) {
        noticeDao.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public Notice findNoticeById(int id) {
        return noticeDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public List<Notice> findAllNotice(Notice notice, PageModel pageModel) {
        Map<String, Object> param = new HashMap<>();
        int recordCount = noticeDao.selectCount(notice);
        if (recordCount > 0) {
            pageModel.setRecordCount(recordCount);
        }
        param.put("notice", notice);
        param.put("pageModel", pageModel);
        int firstlimit = pageModel.getFirstLimitParam();
       return noticeDao.selectWithParam(param);
    }

    
    public void modifyNoticeById(Notice notice) {
        noticeDao.updateNotice(notice);
    }

    //工作接口
    
    public void addJob(Job job) {
        jobDao.insertSelective(job);
    }

    
    public void removeJobById(int id) {
        jobDao.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public Job findJobById(int id) {
        return jobDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    
    public List<Job> findAllJob(Job job, PageModel pageModel) {
        Map<String, Object> param = new HashMap<>();
        int recordCount = jobDao.selectCount(job);
        if (pageModel != null) {
            pageModel.setRecordCount(recordCount);
            if (recordCount > 0) {
                param.put("pageModel", pageModel);
            }
        }
        param.put("job", job);
        return jobDao.selectWithParam(param);
    }

    
    public void modifyJobById(Job job) {
        jobDao.updateByPrimaryKeySelective(job);
    }
}
