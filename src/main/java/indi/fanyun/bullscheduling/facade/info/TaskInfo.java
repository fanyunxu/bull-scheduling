package indi.fanyun.bullscheduling.facade.info;

import cn.hutool.http.Method;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import indi.fanyun.bullscheduling.common.types.ParamType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-14 15:08
 */
@Data
public class TaskInfo {


    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String code;

    /**
     * 任务名称
     */
    @ApiModelProperty("任务名称")
    private String taskName;

    /**
     * 调用地址
     */
    @ApiModelProperty("调用地址")
    private String targetUrl;

    /**
     * http调用方法 get post
     */
    @ApiModelProperty("请求方式")
    private Method method;

    /**
     * cron表达式
     */
    @ApiModelProperty("cron")
    private String cron;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String param;

    /**
     * 参数类型  ParamType
     */
    @ApiModelProperty("参数类型")
    private ParamType paramType;

    /**
     * 操作人CODE
     */
    @ApiModelProperty("操作人CODE")
    private String operateCode;

    /**
     * 操作人名称
     */
    @ApiModelProperty("操作人名称")
    private String operateName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;

    /**
     * 状态 参考NormalStatus
     */
    @ApiModelProperty("状态")
    private NormalStatus status;
}
