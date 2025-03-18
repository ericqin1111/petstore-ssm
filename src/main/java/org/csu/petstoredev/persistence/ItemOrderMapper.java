package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.csu.petstoredev.entity.ItemOrder;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemOrderMapper extends BaseMapper<ItemOrder> {


    @Select("SELECT EXISTS(SELECT 1 FROM item_order where code = #{code})")
    boolean existItemOrder(int code);
}
