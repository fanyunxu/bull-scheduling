package indi.fanyun.bullscheduling.facade.request;

import indi.fanyun.bullscheduling.common.dto.BasePageRequestDTO;
import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tshk
 * @date 2021-01-19 15:18
 */
@Data
public class TaskExeRecordRequestDTO extends BasePageRequestDTO {

    @ApiModelProperty("taskCode")
    private String taskCode;
}
