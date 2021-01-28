package indi.fanyun.bullscheduling.service;

import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import indi.fanyun.bullscheduling.facade.info.LabelResponseDTO;

/**
 * @author tshk
 * @date 2021-01-26 17:04
 */
public interface TaskGroupService {
    /**
     * 获取分组
     * @param requestDTO
     * @return
     */
    LabelResponseDTO getGroups(BaseRequestDTO requestDTO);
}
