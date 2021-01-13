package indi.fanyun.bullscheduling.web;

import indi.fanyun.bullscheduling.common.BaseRequestDTO;
import indi.fanyun.bullscheduling.common.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.model.info.JobInfo;
import indi.fanyun.bullscheduling.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author tshk
 * @date 2021-01-12 14:37
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @PostMapping("/edit")
    @ApiOperation("编辑任务")
    @ResponseBody
    public BaseResponseDTO edit(@RequestBody @Valid TaskEditRequestDTO requestDTO){
        return taskService.edit(requestDTO);
    }

    @GetMapping("/test")
    @ApiOperation("编辑任务")
    public BaseResponseDTO get(){
        System.out.println("get====");
        return new BaseResponseDTO();
    }

    @PostMapping("/test")
    @ApiOperation("编辑任务")
    public BaseResponseDTO post(@RequestBody JobInfo jobInfo){
        System.out.println("post===="+jobInfo.getTaskName());
        return new BaseResponseDTO();
    }
}
