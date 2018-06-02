package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 报名表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@TableName("message")
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 电话
     */
    private String tel;
    /**
     * 姓名
     */
    private String name;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 处理人
     */
    private Integer processid;
    /**
     * 处理意见
     */
    @TableField("process_remark")
    private Integer processRemark;
    /**
     * 处理结果
     */
    @TableField("process_result")
    private Integer processResult;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProcessid() {
        return processid;
    }

    public void setProcessid(Integer processid) {
        this.processid = processid;
    }

    public Integer getProcessRemark() {
        return processRemark;
    }

    public void setProcessRemark(Integer processRemark) {
        this.processRemark = processRemark;
    }

    public Integer getProcessResult() {
        return processResult;
    }

    public void setProcessResult(Integer processResult) {
        this.processResult = processResult;
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
        return "Message{" +
        "id=" + id +
        ", tel=" + tel +
        ", name=" + name +
        ", content=" + content +
        ", status=" + status +
        ", processid=" + processid +
        ", processRemark=" + processRemark +
        ", processResult=" + processResult +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
