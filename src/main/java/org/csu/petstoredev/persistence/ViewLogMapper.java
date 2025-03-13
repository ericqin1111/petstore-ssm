package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.csu.petstoredev.entity.ViewLog;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ViewLogMapper extends BaseMapper<ViewLog> {
@Insert("insert into viewlog(history) values (#{history}) ")
    public int viewInsert(String history);
}
