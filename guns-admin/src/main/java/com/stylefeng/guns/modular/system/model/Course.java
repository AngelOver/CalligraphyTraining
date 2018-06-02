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
 * 成长历程表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@TableName("course")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学员id
     */
    private Integer studentid;
    /**
     * 老师id
     */
    private Integer teacherid;
    /**
     * 时间
     */
    private String time;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片
     */
    private String image;
    /**
     * 主题
     */
    private String theme;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 内容
     */
    private String content;
    /**
     * 备注
     */
    private String remark;
    /**
     * 回复
     */
    private String reply;
    /**
     * 留言
     */
    private String message;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更新时间
     */
    private Date updatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Course{" +
        "id=" + id +
        ", studentid=" + studentid +
        ", teacherid=" + teacherid +
        ", time=" + time +
        ", title=" + title +
        ", image=" + image +
        ", theme=" + theme +
        ", summary=" + summary +
        ", keywords=" + keywords +
        ", content=" + content +
        ", remark=" + remark +
        ", reply=" + reply +
        ", message=" + message +
        ", status=" + status +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
