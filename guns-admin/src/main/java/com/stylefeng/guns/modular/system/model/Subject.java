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
 * 课程表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@TableName("subject")
public class Subject extends Model<Subject> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 课程分类id
     */
    private Integer cateoryid;
    /**
     * 开课人id
     */
    private Integer teaid;
    /**
     * 开课人
     */
    private String teaname;
    /**
     * 课程名
     */
    private String name;
    /**
     * 课程编码
     */
    private String code;
    /**
     * 标题
     */
    private String title;
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
     * 地址
     */
    private String address;
    /**
     * 课程时间段
     */
    private String range;
    /**
     * 开始时间
     */
    private String starttime;
    /**
     * 结束时间
     */
    private String endtime;
    /**
     * 总课时数
     */
    private Integer totalcount;
    /**
     * 当前课时数
     */
    private Integer nowcount;
    /**
     * 状态(0 未开始 1 进行中 2 已完成 3未完成 4已过期)
     */
    private Integer status;
    /**
     * 创建人id
     */
    private Integer createid;
    /**
     * 创建人
     */
    private String createname;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改人id
     */
    private Integer updateid;
    /**
     * 修改人
     */
    private String updatename;
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

    public Integer getCateoryid() {
        return cateoryid;
    }

    public void setCateoryid(Integer cateoryid) {
        this.cateoryid = cateoryid;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }

    public Integer getNowcount() {
        return nowcount;
    }

    public void setNowcount(Integer nowcount) {
        this.nowcount = nowcount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateid() {
        return createid;
    }

    public void setCreateid(Integer createid) {
        this.createid = createid;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdateid() {
        return updateid;
    }

    public void setUpdateid(Integer updateid) {
        this.updateid = updateid;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename;
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
        return "Subject{" +
        "id=" + id +
        ", cateoryid=" + cateoryid +
        ", teaid=" + teaid +
        ", teaname=" + teaname +
        ", name=" + name +
        ", code=" + code +
        ", title=" + title +
        ", theme=" + theme +
        ", summary=" + summary +
        ", keywords=" + keywords +
        ", content=" + content +
        ", remark=" + remark +
        ", address=" + address +
        ", range=" + range +
        ", starttime=" + starttime +
        ", endtime=" + endtime +
        ", totalcount=" + totalcount +
        ", nowcount=" + nowcount +
        ", status=" + status +
        ", createid=" + createid +
        ", createname=" + createname +
        ", createtime=" + createtime +
        ", updateid=" + updateid +
        ", updatename=" + updatename +
        ", updatetime=" + updatetime +
        "}";
    }
}
