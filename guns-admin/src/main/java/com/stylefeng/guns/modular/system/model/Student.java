package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 学员表
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@TableName("student")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学号
     */
    private String code;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * md5密码盐
     */
    private String salt;
    /**
     * 名字
     */
    private String name;
    /**
     * 昵称
     */
    private String nick;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 电话
     */
    private String phone;
    /**
     * 监1：启用护人
     */
    private String guardian;
    /**
     * 状态(  2：冻结  3：删除）
     */
    private Integer status;
    /**
     * 课时数
     */
    private Integer subjectcount;
    /**
     * 微信openid
     */
    private String openid;
    /**
     * qq号
     */
    private String qq;
    /**
     * wx号
     */
    private String wx;
    /**
     * 第三方登录类型1-QQ 2-微信 3-新浪
     */
    private Integer thirdtype;
    /**
     * token
     */
    private String thirdtoken;
    /**
     * 身份验证
     */
    @TableField("is_verify")
    private Integer isVerify;
    /**
     * 余额
     */
    private BigDecimal money;
    /**
     * 冻结金额
     */
    @TableField("frozen_money")
    private BigDecimal frozenMoney;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSubjectcount() {
        return subjectcount;
    }

    public void setSubjectcount(Integer subjectcount) {
        this.subjectcount = subjectcount;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Integer getThirdtype() {
        return thirdtype;
    }

    public void setThirdtype(Integer thirdtype) {
        this.thirdtype = thirdtype;
    }

    public String getThirdtoken() {
        return thirdtoken;
    }

    public void setThirdtoken(String thirdtoken) {
        this.thirdtoken = thirdtoken;
    }

    public Integer getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(Integer isVerify) {
        this.isVerify = isVerify;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
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
        return "Student{" +
        "id=" + id +
        ", code=" + code +
        ", avatar=" + avatar +
        ", account=" + account +
        ", password=" + password +
        ", salt=" + salt +
        ", name=" + name +
        ", nick=" + nick +
        ", birthday=" + birthday +
        ", sex=" + sex +
        ", email=" + email +
        ", tel=" + tel +
        ", phone=" + phone +
        ", guardian=" + guardian +
        ", status=" + status +
        ", subjectcount=" + subjectcount +
        ", openid=" + openid +
        ", qq=" + qq +
        ", wx=" + wx +
        ", thirdtype=" + thirdtype +
        ", thirdtoken=" + thirdtoken +
        ", isVerify=" + isVerify +
        ", money=" + money +
        ", frozenMoney=" + frozenMoney +
        ", createtime=" + createtime +
        "}";
    }
}
