package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.csu.petstoredev.entity.Item;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemMapper extends BaseMapper<Item> {
}
