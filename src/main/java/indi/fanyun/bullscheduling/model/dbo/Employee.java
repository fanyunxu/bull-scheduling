package indi.fanyun.bullscheduling.model.dbo;

import lombok.Builder;

import java.util.Date;
import javax.persistence.*;

@Table(name = "b_employee")
@Builder
public class Employee {

    @Column(name = "ID")
    private Integer id;

    /**
     * 主键
     */
    @Id
    @Column(name = "CODE")
    private String code;

    /**
     * 账号
     */
    @Column(name = "ACCOUNT")
    private String account;

    /**
     * 密码(两次md5)+salt
     */
    @Column(name = "PWD")
    private String pwd;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 手机号
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "GMT_CREATE")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "GMT_MODIFY")
    private Date gmtModify;

    /**
     * 状态 参考NormalStatus
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主键
     *
     * @return CODE - 主键
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置主键
     *
     * @param code 主键
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取账号
     *
     * @return ACCOUNT - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码(两次md5)+salt
     *
     * @return PWD - 密码(两次md5)+salt
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码(两次md5)+salt
     *
     * @param pwd 密码(两次md5)+salt
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号
     *
     * @return PHONE - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取创建时间
     *
     * @return GMT_CREATE - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return GMT_MODIFY - 修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModify 修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取状态 参考NormalStatus
     *
     * @return STATUS - 状态 参考NormalStatus
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 参考NormalStatus
     *
     * @param status 状态 参考NormalStatus
     */
    public void setStatus(String status) {
        this.status = status;
    }
}