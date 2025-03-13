package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.csu.petstoredev.vo.UserVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserVO> {
    @Select("select * from signon where username = #{username} And password = #{password}")
    public UserVO selectByusrnameAndPsw(@Param("username") String username, @Param("password") String password);

}
