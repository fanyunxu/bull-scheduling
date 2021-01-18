package indi.fanyun.bullscheduling.service;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.dto.CodeRequestDTO;
import indi.fanyun.bullscheduling.facade.request.EmployeeLoginRequestDTO;
import indi.fanyun.bullscheduling.facade.response.EmployeeLoginResponseDTO;

/**
 * @author tshk
 * @date 2021-01-18 11:47
 */
public interface EmployeeService {
    /**
     * 登录
     * @param requestDTO
     * @return
     */
    EmployeeLoginResponseDTO login(EmployeeLoginRequestDTO requestDTO);

    /**
     * 登出
     * @param requestDTO
     * @return
     */
    BaseResponseDTO loginOut(CodeRequestDTO requestDTO);
}
