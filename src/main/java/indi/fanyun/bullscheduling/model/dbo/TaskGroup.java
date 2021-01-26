package indi.fanyun.bullscheduling.model.dbo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_task_group")
public class TaskGroup {
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 主键
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 任务名称
     */
    @Column(name = "GROUP_NAME")
    private String groupName;

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
     * @return GROUP_NAME - 任务名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置任务名称
     *
     * @param groupName 任务名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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