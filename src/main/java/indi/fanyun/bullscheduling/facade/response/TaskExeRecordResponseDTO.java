package indi.fanyun.bullscheduling.facade.response;

import indi.fanyun.bullscheduling.common.dto.BasePageResponseDTO;
import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.info.TaskExeRecordInfo;
import lombok.Data;

import java.util.List;

/**
 * @author tshk
 * @date 2021-01-19 15:17
 */
@Data
public class TaskExeRecordResponseDTO extends BasePageResponseDTO {

    private List<TaskExeRecordInfo> recordInfos;
}
