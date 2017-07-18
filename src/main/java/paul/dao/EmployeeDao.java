package paul.dao;


import org.springframework.stereotype.Repository;
import paul.domain.Employee;

import java.util.List;
import java.util.Map;
@Repository
public interface EmployeeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbg.generated
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbg.generated
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbg.generated
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbg.generated
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbg.generated
     */

    //根据id查
    Employee selectByPrimaryKey(Integer id);
    //动态查询总数量
    int selectCount(Employee employee);
    //分页动态查询
    List<Employee> selectWithParam(Map<String, Object> map);
     //动态插入
    int insertSelective(Employee record);
     //动态更新
    int updateByPrimaryKeySelective(Employee record);
}