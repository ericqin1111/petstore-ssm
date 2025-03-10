package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.csu.petstoredev.form.User;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from signon where username = #{username} And password = #{password}")
    public User selectByusrnameAndPsw(@Param("username") String username,@Param("password") String password);

}
