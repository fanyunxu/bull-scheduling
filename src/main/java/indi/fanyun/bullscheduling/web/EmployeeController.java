package indi.fanyun.bullscheduling.web;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.dto.CodeRequestDTO;
import indi.fanyun.bullscheduling.common.group.CodeGroup;
import indi.fanyun.bullscheduling.common.group.SelectGroup;
import indi.fanyun.bullscheduling.facade.request.EmployeeLoginRequestDTO;
import indi.fanyun.bullscheduling.facade.response.EmployeeLoginResponseDTO;
import indi.fanyun.bullscheduling.service.EmployeeService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tshk
 * @date 2021-01-18 11:47
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public EmployeeLoginResponseDTO login(@RequestBody @Validated(value = {SelectGroup.class}) EmployeeLoginRequestDTO requestDTO){
        return employeeService.login(requestDTO);
    }
    @ApiModelProperty("登出")
    @PostMapping("/loginOut")
    public BaseResponseDTO loginOut(@RequestBody @Validated(value = {CodeGroup.class})CodeRequestDTO requestDTO){
        return employeeService.loginOut(requestDTO);
    }
}
