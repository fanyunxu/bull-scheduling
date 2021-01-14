package indi.fanyun.bullscheduling.facade.response;

/**
 * @author tshk
 * @date 2021-01-14 14:54
 */

import indi.fanyun.bullscheduling.common.dto.BasePageResponseDTO;
import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.info.TaskInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 任务列表
 */
@Data
public class TaskListResponseDTO extends BasePageResponseDTO {

    @ApiModelProperty("任务列表")
    private List<TaskInfo> taskInfos;

}
