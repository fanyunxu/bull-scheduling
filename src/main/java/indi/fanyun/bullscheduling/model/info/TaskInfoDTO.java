package indi.fanyun.bullscheduling.model.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tshk
 * @date 2021-01-14 15:26
 */
@Data
public class TaskInfoDTO {

    @ApiModelProperty("code")
    private String code;

    @ApiModelProperty("任务名称")
    private String taskName;

    @ApiModelProperty("状态")
    private String taskStatus;
}
