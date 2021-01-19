package indi.fanyun.bullscheduling.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import indi.fanyun.bullscheduling.common.exceptions.MyBizException;
import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.dto.CodeRequestDTO;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import indi.fanyun.bullscheduling.facade.info.EmployeeInfo;
import indi.fanyun.bullscheduling.facade.request.EmployeeLoginRequestDTO;
import indi.fanyun.bullscheduling.facade.response.EmployeeLoginResponseDTO;
import indi.fanyun.bullscheduling.mapper.EmployeeMapper;
import indi.fanyun.bullscheduling.model.dbo.Employee;
import indi.fanyun.bullscheduling.service.EmployeeService;
import indi.fanyun.bullscheduling.session.EmployeeLocalSession;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tshk
 * @date 2021-01-18 11:47
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private EmployeeLocalSession employeeLocalSession;

    @Override
    public EmployeeLoginResponseDTO login(EmployeeLoginRequestDTO requestDTO) {
        List<Employee> employees = employeeMapper.select(Employee.builder()
                .account(requestDTO.getAccount())
                .pwd(SecureUtil.md5(requestDTO.getPwd()))
                .build()
        );
        if(CollectionUtil.isEmpty(employees)){
            throw new MyBizException("密码错误或者账号不存在");
        }
        Employee employee = employees.get(0);
        if(!NormalStatus.USING.name().equals(employee.getStatus())){
            throw new MyBizException("当前用户状态异常");
        }
        EmployeeInfo map = mapperFacade.map(employee, EmployeeInfo.class);
        String fastUUID = IdUtil.fastSimpleUUID();
        EmployeeLoginResponseDTO responseDTO=new EmployeeLoginResponseDTO();
        responseDTO.setEmployeeInfo(map);
        responseDTO.setToken(fastUUID);
        employeeLocalSession.registerSession(fastUUID,map);
        return responseDTO;
    }

    @Override
    public BaseResponseDTO loginOut(CodeRequestDTO requestDTO) {
        employeeLocalSession.remove(requestDTO.getCode());
        return new BaseResponseDTO();
    }
}
