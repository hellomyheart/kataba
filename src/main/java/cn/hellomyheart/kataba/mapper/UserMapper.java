package cn.hellomyheart.kataba.mapper;

import cn.hellomyheart.kataba.dto.UserDto;
import cn.hellomyheart.kataba.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * @description
 * @className: UserMapper
 * @package: cn.hellomyheart.kataba.mapper
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:42
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where nickname = #{n} or phone =#{n}")
    @ResultType(User.class)
    User selectByName(String n);

    @Select("select * from t_user where nickname =#{n} or phone = #{p}")
    @ResultType(User.class)
    User selectByNamePhone(@Param("n") String n,@Param("p") String p);

    @Insert("insert  into t_user(nickname,phone,password,flag) values(#{nickname},#{phone},#{password} ,1)")
    int insertDto(UserDto dto);
}
