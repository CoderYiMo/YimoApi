package com.yimo.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName menu
 */
@TableName(value ="menu")
@Data
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String menuName;

    /**
     * 
     */
    private Long parentId;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}