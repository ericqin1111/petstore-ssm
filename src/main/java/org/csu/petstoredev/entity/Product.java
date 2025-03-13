package org.csu.petstoredev.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product")
public class Product {
    @TableId("productid")
    private String productId;
    @TableField("category")
    private String categoryId;
    private String name;
    @TableField("descn")
    private String description;
    @TableField("pic")
    private String pic;


}
