package indi.fanyun.bullscheduling.service;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskQueryRequestDTO;
import indi.fanyun.bullscheduling.facade.response.TaskListResponseDTO;

/**
 * @author tshk
 * @date 2021-01-12 14:38
 */
public interface TaskService {
    /**
     * 编辑任务
     * @param requestDTO
     * @return
     */
    BaseResponseDTO edit(TaskEditRequestDTO requestDTO) ;

    /**
     * 查询任务列表
     * @param requestDTO
     * @return
     */
    TaskListResponseDTO queryTaskList(TaskQueryRequestDTO requestDTO);
}
