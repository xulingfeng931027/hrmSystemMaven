package paul.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import paul.domain.Department;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept_inf
     *
     * @mbg.generated
     */

    //动态查询
    int deleteByPrimaryKey(Integer id);

    //分页动态查询
    List<Department> selectWithParam(Map<String, Object> map);
    //根据id查询
    Department selectByPrimaryKey(Integer id);

    //查出所有部门
    @Select("select * from dept_inf")
    List<Department> selectAllDept();


    //动态查询总数量
    int selectCount(Department department);

    //动态插入
    int insertSelective(Department record);

    //动态更新

    int updateByPrimaryKey(Department record);
}