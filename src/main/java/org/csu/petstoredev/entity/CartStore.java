package org.csu.petstoredev.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cartstore")
public class CartStore {
    @TableId(value ="username")
    private String userName;
    @TableField("itemid")
    private String itemId;
    @TableField("quantity")
    private Integer quantity;
}
