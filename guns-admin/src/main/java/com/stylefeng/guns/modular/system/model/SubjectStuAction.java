package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程-学生关系表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@TableName("subject_stu_action")
public class SubjectStuAction extends Model<SubjectStuAction> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 课程id
     */
    private Integer subjectid;
    /**
     * 学员id
     */
    private Integer studentid;
    /**
     * 课时数
     */
    private Integer subjectcount;
    /**
     * 创建时间
     */
    private Date createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getSubjectcount() {
        return subjectcount;
    }

    public void setSubjectcount(Integer subjectcount) {
        this.subjectcount = subjectcount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SubjectStuAction{" +
        "id=" + id +
        ", subjectid=" + subjectid +
        ", studentid=" + studentid +
        ", subjectcount=" + subjectcount +
        ", createtime=" + createtime +
        "}";
    }
}
