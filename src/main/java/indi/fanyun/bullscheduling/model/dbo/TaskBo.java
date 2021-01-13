package indi.fanyun.bullscheduling.model.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_task")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskBo {

    @Column(name = "ID")
    private Integer id;

    /**
     * 主键
     */
    @Id
    @Column(name = "CODE")
    private String code;

    /**
     * 任务名称
     */
    @Column(name = "TASK_NAME")
    private String taskName;

    /**
     * 调用地址
     */
    @Column(name = "TARGET_URL")
    private String targetUrl;

    /**
     * http调用方法 get post
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * cron表达式
     */
    @Column(name = "CRON")
    private String cron;

    /**
     * 请求参数
     */
    @Column(name = "PARAM")
    private String param;

    /**
     * 参数类型  ParamType
     */
    @Column(name = "PARAM_TYPE")
    private String paramType;

    /**
     * 操作人CODE
     */
    @Column(name = "OPERATE_CODE")
    private String operateCode;

    /**
     * 操作人名称
     */
    @Column(name = "OPERATE_NAME")
    private String operateName;

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
     * 获取任务名称
     *
     * @return TASK_NAME - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取调用地址
     *
     * @return TARGET_URL - 调用地址
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * 设置调用地址
     *
     * @param targetUrl 调用地址
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    /**
     * 获取http调用方法 get post
     *
     * @return METHOD - http调用方法 get post
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置http调用方法 get post
     *
     * @param method http调用方法 get post
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取cron表达式
     *
     * @return CRON - cron表达式
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置cron表达式
     *
     * @param cron cron表达式
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * 获取请求参数
     *
     * @return PARAM - 请求参数
     */
    public String getParam() {
        return param;
    }

    /**
     * 设置请求参数
     *
     * @param param 请求参数
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * 获取参数类型  ParamType
     *
     * @return PARAM_TYPE - 参数类型  ParamType
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * 设置参数类型  ParamType
     *
     * @param paramType 参数类型  ParamType
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    /**
     * 获取操作人CODE
     *
     * @return OPERATE_CODE - 操作人CODE
     */
    public String getOperateCode() {
        return operateCode;
    }

    /**
     * 设置操作人CODE
     *
     * @param operateCode 操作人CODE
     */
    public void setOperateCode(String operateCode) {
        this.operateCode = operateCode;
    }

    /**
     * 获取操作人名称
     *
     * @return OPERATE_NAME - 操作人名称
     */
    public String getOperateName() {
        return operateName;
    }

    /**
     * 设置操作人名称
     *
     * @param operateName 操作人名称
     */
    public void setOperateName(String operateName) {
        this.operateName = operateName;
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