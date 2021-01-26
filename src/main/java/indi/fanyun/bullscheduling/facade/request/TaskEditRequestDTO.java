package indi.fanyun.bullscheduling.facade.request;

import cn.hutool.http.Method;
import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import indi.fanyun.bullscheduling.common.types.ParamType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author tshk
 * @date 2021-01-12 14:58
 */
@Data
public class TaskEditRequestDTO extends BaseRequestDTO {

    @ApiModelProperty("任务code")
    private String code;
    @ApiModelProperty("任务名称")
    @NotBlank(message = "任务名称不得为空")
    private String taskName;
    @ApiModelProperty("调用地址url")
    @NotBlank(message = "调用地址url不得为空")
    private String targetUrl;
    @ApiModelProperty("方法")
    @NotNull(message = "请求方法不得为空")
    private Method method;
    @ApiModelProperty("执行时间")
    @NotBlank(message = "cron不得为空")
    private String cron;
    @ApiModelProperty("参数")
    private String param;
    @ApiModelProperty("参数类型")
    @NotNull(message = "参数类型不得为空")
    private ParamType paramType;
    @ApiModelProperty("状态")
    private NormalStatus status=NormalStatus.USING;
    @ApiModelProperty("分组code")
    private String groupCode;

}
