package paul.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import paul.domain.User;

import java.util.List;
import java.util.Map;

import static paul.utils.HrmConstants.USERTABLE;


@Repository
public interface UserDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_inf
     * 根据ID删除用户
     *
     * @mbg.generated
     */
    int deleteById(Integer id);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_inf
     *
     * @mbg.generated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_inf
     *
     * @mbg.generated
     */
    User selectByPrimaryKey(Integer id);

    //根据登录名和密码查询员工
    @Select("select * from " + USERTABLE + " WHERE username=#{username} and password =#{password}")
    User selectByUsernameAndPassword(@Param("username") String username,
                                     @Param("password") String password);

    //查询总数量
    int selectCount(User user);

    //分页查询
    List<User> selectWithParam(Map<String, Object> param);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_inf
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_inf
     *
     * @mbg.generated++++++++++++++++++-++++
     */
    int updateByPrimaryKey(User record);
}