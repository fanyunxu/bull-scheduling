package indi.fanyun.bullscheduling.facade.request;

import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import indi.fanyun.bullscheduling.common.group.SelectGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author tshk
 * @date 2021-01-18 11:55
 */
@Data
public class EmployeeLoginRequestDTO extends BaseRequestDTO {

    @ApiModelProperty("账号")
    @NotBlank(message = "账号不得为空",groups = SelectGroup.class)
    private String account;

    @ApiModelProperty("密码(一次Md5)")
    @NotBlank(message = "密码不得为空",groups = SelectGroup.class)
    private String pwd;
}
