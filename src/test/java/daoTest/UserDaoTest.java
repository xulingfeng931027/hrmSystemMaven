package daoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import paul.config.RootConfig;
import paul.dao.UserDao;
import paul.domain.User;
import paul.utils.PageModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017-07-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user = userDao.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void selectByUsernameAndPassword() throws Exception {
        User user = userDao.selectByUsernameAndPassword("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void selectCount() throws Exception {
        Map<String, Object> params = new HashMap<>();
        User user = new User();
        params.put("user", user);
        user.setUsername("admin");
        int count = userDao.selectCount(user);
        System.out.println(count);
    }

    @Test
    public void selectWithParam() throws Exception {
        Map<String,Object> map = new HashMap<>();

       User user  =  new User();
        user.setName("部");

        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(2);
//        map.put("pageModel",pageModel);
        map.put("user",user);

        List<User> list = userDao.selectWithParam(map);
        for(User user1:list){
            System.out.println(user1.getName());
        }
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }



}
