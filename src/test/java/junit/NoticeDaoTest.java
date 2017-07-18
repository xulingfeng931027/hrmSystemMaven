package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import paul.config.RootConfig;
import paul.dao.NoticeDao;
import paul.domain.Notice;
import paul.domain.User;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NoticeDaoTest {
    @Autowired
    private NoticeDao noticeDao;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectWithParam() throws Exception {
    }

    @Test
    public void updateNotice() throws Exception {
    }

    @Test
    public void selectCount() throws Exception {
        int i = noticeDao.selectCount(new Notice());
        assert i == 1;
    }

    @Test
    public void insertSelective() throws Exception {
        Notice notice = new Notice();
        notice.setTitle("新公告");
        notice.setContent("sdf胜多负少的发展现场发生单号发我哈大方向参加活动");
        User user = new User();
        user.setId(1);
        notice.setUser(user);
        noticeDao.insertSelective(notice);
    }

}