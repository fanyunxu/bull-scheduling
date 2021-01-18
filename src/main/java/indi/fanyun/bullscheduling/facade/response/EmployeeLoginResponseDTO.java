package indi.fanyun.bullscheduling.facade.response;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.info.EmployeeInfo;
import indi.fanyun.bullscheduling.model.dbo.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tshk
 * @date 2021-01-18 11:54
 */
@Data
public class EmployeeLoginResponseDTO extends BaseResponseDTO {

    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("员工信息")
    private EmployeeInfo employeeInfo;
}
