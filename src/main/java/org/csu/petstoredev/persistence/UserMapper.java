package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.csu.petstoredev.form.User;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from signon where username = #{username} And password = #{password}")
    public User selectByusrnameAndPsw(@Param("username") String username,@Param("password") String password);

    @Select("select * from signon where username=#{username}")
    public User selectByUsername(@Param("username") String username);

    @Insert("insert into signon(username,password) values (#{username},#{password})")
    public int insertToSignonUsrAndPsw(@Param("username") String username,@Param("password") String password);

}
