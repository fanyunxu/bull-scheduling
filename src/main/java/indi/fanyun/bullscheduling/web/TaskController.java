package indi.fanyun.bullscheduling.web;

import indi.fanyun.bullscheduling.common.annotation.OperatorAuthentication;
import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.dto.CodeRequestDTO;
import indi.fanyun.bullscheduling.common.group.CodeGroup;
import indi.fanyun.bullscheduling.common.group.OperateGroup;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskExeRecordRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskQueryRequestDTO;
import indi.fanyun.bullscheduling.facade.response.TaskExeRecordResponseDTO;
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
    @OperatorAuthentication
    public BaseResponseDTO edit(@RequestBody @Valid TaskEditRequestDTO requestDTO){
        return taskService.edit(requestDTO);
    }

    @PostMapping("/list")
    @ApiOperation("查询任务列表")
    @ResponseBody
    @OperatorAuthentication
    public TaskListResponseDTO queryTaskList(@RequestBody TaskQueryRequestDTO requestDTO){
        return taskService.queryTaskList(requestDTO);
    }

    @PostMapping("/delete")
    @ApiOperation("删除任务")
    @ResponseBody
    @OperatorAuthentication
    public BaseResponseDTO deleteTask(@RequestBody @Validated(value = {CodeGroup.class}) CodeRequestDTO requestDTO){
        return taskService.deleteTask(requestDTO);
    }

    @PostMapping("/control")
    @ApiOperation("恢复或暂停任务")
    @ResponseBody
    @OperatorAuthentication
    public BaseResponseDTO controlTask(@RequestBody @Validated(value = {CodeGroup.class}) CodeRequestDTO requestDTO){
        return taskService.controlTask(requestDTO);
    }

    @PostMapping("/taskExeRecord")
    @ApiOperation("/查询任务执行记录")
    @ResponseBody
    @OperatorAuthentication
    public TaskExeRecordResponseDTO getTaskExeRecords(@RequestBody @Validated(value = { OperateGroup.class})TaskExeRecordRequestDTO recordRequestDTO){
        return taskService.getTaskExeRecords(recordRequestDTO);
    }
}
