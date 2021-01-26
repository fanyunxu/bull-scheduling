package indi.fanyun.bullscheduling.model.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_task")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @Column(name = "GROUP_CODE")
    private String groupCode;

}