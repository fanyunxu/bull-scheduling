package indi.fanyun.bullscheduling.service;

import indi.fanyun.bullscheduling.common.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import org.quartz.SchedulerException;

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
}
