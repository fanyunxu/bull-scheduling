package indi.fanyun.bullscheduling.web;

import indi.fanyun.bullscheduling.common.annotation.OperatorAuthentication;
import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import indi.fanyun.bullscheduling.facade.info.LabelResponseDTO;
import indi.fanyun.bullscheduling.service.TaskGroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tshk
 * @date 2021-01-26 14:49
 */
@RestController
@RequestMapping("/task/group")
public class TaskGroupController {

    @Resource
    private TaskGroupService taskGroupService;

    @PostMapping("/get")
    @OperatorAuthentication
    public LabelResponseDTO getGroups(@RequestBody BaseRequestDTO requestDTO){
        return taskGroupService.getGroups(requestDTO);
    }
}
