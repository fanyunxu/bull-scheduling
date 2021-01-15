package indi.fanyun.bullscheduling.web;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.dto.CodeRequestDTO;
import indi.fanyun.bullscheduling.common.group.CodeGroup;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskQueryRequestDTO;
import indi.fanyun.bullscheduling.facade.response.TaskListResponseDTO;
import indi.fanyun.bullscheduling.service.TaskService;
import io.swagger.annotations.ApiModelProperty;
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

    @PostMapping("/list")
    @ApiOperation("查询任务列表")
    @ResponseBody
    public TaskListResponseDTO queryTaskList(@RequestBody TaskQueryRequestDTO requestDTO){
        return taskService.queryTaskList(requestDTO);
    }

    @PostMapping("/delete")
    @ApiOperation("删除任务")
    @ResponseBody
    public BaseResponseDTO deleteTask(@RequestBody @Validated(value = {CodeGroup.class}) CodeRequestDTO requestDTO){
        return taskService.deleteTask(requestDTO);
    }

    @PostMapping("/control")
    @ApiOperation("恢复或暂停任务")
    @ResponseBody
    public BaseResponseDTO controlTask(@RequestBody @Validated(value = {CodeGroup.class}) CodeRequestDTO requestDTO){
        return taskService.controlTask(requestDTO);
    }

//    @GetMapping("/test")
//    @ApiOperation("编辑任务")
//    public BaseResponseDTO get(){
//        System.out.println("get====");
//        return new BaseResponseDTO();
//    }

//    @PostMapping("/test")
//    @ApiOperation("编辑任务")
//    public BaseResponseDTO post(@RequestBody JobInfo jobInfo){
//        System.out.println("post===="+jobInfo.getTaskName());
//        return new BaseResponseDTO();
//    }
}
