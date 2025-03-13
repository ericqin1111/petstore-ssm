package org.csu.petstoredev.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("viewlog")
public class ViewLog {
    @TableId("time")
    private Date time;
    @TableField("history")
    private String history;
}
