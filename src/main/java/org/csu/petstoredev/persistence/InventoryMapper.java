package org.csu.petstoredev.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.csu.petstoredev.entity.Inventory;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InventoryMapper extends BaseMapper<Inventory> {
    @Select("select * from inventory where itemid=#{itemId}")
    public Inventory[] getInventoryByItemId(@Param("itemId") String itemId);

    @Update("update inventory set qty =#{quantity} where itemid=#{itemId}")
    public void updateQty(@Param("itemId") String itemId, @Param("quantity") Integer quantity);
}
