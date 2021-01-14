package indi.fanyun.bullscheduling.facade.request;

import indi.fanyun.bullscheduling.common.dto.BasePageRequestDTO;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tshk
 * @date 2021-01-14 15:02
 */
@Data
public class TaskQueryRequestDTO extends BasePageRequestDTO {

    @ApiModelProperty("任务名称")
    private String taskName;
    @ApiModelProperty("任务状态")
    private NormalStatus taskStatus;
}
