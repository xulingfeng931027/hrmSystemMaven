package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import paul.config.RootConfig;
import paul.dao.DepartmentDao;
import paul.domain.Department;

import java.util.List;

/**
 * Created by paul on 2017-07-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao ;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void selectWithParam() throws Exception {

        List<Department> list = departmentDao.selectWithParam(null);
        for(Department department:list){
            System.out.println(department.getName());
        }
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void selectAllDept() throws Exception {
    }

    @Test
    public void selectCount() throws Exception {
        int i = departmentDao.selectCount(null);
        System.out.println(i);
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
        Department dept  =  new Department();
        dept.setName("技术部");
        dept.setRemark("jishub");
        System.out.println(departmentDao.insertSelective(dept));


    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }


}
