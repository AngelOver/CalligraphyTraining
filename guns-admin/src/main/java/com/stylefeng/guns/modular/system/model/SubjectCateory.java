package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程分类表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@TableName("subject_cateory")
public class SubjectCateory extends Model<SubjectCateory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 课程分类名
     */
    private String name;
    /**
     * 课程分类编码
     */
    private String key;
    /**
     * 课程分类编号
     */
    private String code;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态(0 禁用 1 启用)
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SubjectCateory{" +
        "id=" + id +
        ", pid=" + pid +
        ", name=" + name +
        ", key=" + key +
        ", code=" + code +
        ", sort=" + sort +
        ", status=" + status +
        "}";
    }
}
