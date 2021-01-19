package indi.fanyun.bullscheduling.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.fanyun.bullscheduling.common.exceptions.MyBizException;
import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.dto.CodeRequestDTO;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import indi.fanyun.bullscheduling.facade.info.TaskExeRecordInfo;
import indi.fanyun.bullscheduling.facade.info.TaskInfo;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskExeRecordRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskQueryRequestDTO;
import indi.fanyun.bullscheduling.facade.response.TaskExeRecordResponseDTO;
import indi.fanyun.bullscheduling.facade.response.TaskListResponseDTO;
import indi.fanyun.bullscheduling.mapper.TaskExeRecordMapper;
import indi.fanyun.bullscheduling.mapper.TaskMapper;
import indi.fanyun.bullscheduling.model.dbo.TaskBo;
import indi.fanyun.bullscheduling.model.dbo.TaskExeRecord;
import indi.fanyun.bullscheduling.model.dto.TaskExeRecordDTO;
import indi.fanyun.bullscheduling.model.info.JobInfo;
import indi.fanyun.bullscheduling.model.info.TaskInfoDTO;
import indi.fanyun.bullscheduling.scheduling.core.SchedulerAllJob;
import indi.fanyun.bullscheduling.service.TaskService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-12 14:38
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private TaskExeRecordMapper taskExeRecordMapper;

    @Resource
    private MapperFacade obj2ObjMapper;

    @Resource
    private SchedulerAllJob schedulerAllJob;

    @Override
    public BaseResponseDTO edit(TaskEditRequestDTO requestDTO)  {
        BaseResponseDTO baseResponseDTO=new BaseResponseDTO();
        TaskBo map = obj2ObjMapper.map(requestDTO, TaskBo.class);
        map.setGmtModify(new Date());
        if(StrUtil.isBlank(requestDTO.getCode())){
            map.setCode(SecureUtil.md5("add"+System.currentTimeMillis()));
            map.setGmtCreate(new Date());
            map.setOperateCode(requestDTO.getOperateId());
            map.setOperateName(requestDTO.getOperateName());
            taskMapper.insertSelective(map);
        }else {
            taskMapper.updateByPrimaryKeySelective(map);
        }
        JobInfo jobInfo = obj2ObjMapper.map(map, JobInfo.class);
        if(NormalStatus.DISABLE.name().equals(map.getStatus())){
            schedulerAllJob.remove(jobInfo);
            return baseResponseDTO;
        }
        schedulerAllJob.remove(jobInfo);
        schedulerAllJob.add(jobInfo);
        return baseResponseDTO;
    }

    @Override
    public TaskListResponseDTO queryTaskList(TaskQueryRequestDTO requestDTO) {
        Page<TaskBo> page = PageHelper.startPage(requestDTO.getPage(), requestDTO.getSize());
        TaskInfoDTO taskInfoDTO = obj2ObjMapper.map(requestDTO, TaskInfoDTO.class);
        taskMapper.selectByParam(taskInfoDTO);
        TaskListResponseDTO taskListResponseDTO=new TaskListResponseDTO();
        taskListResponseDTO.setTaskInfos(obj2ObjMapper.mapAsList(page.getResult(), TaskInfo.class));
        taskListResponseDTO.setTotal(page.getTotal());
        return taskListResponseDTO;
    }

    @Override
    public BaseResponseDTO deleteTask(CodeRequestDTO requestDTO) {
        TaskBo taskBo = taskMapper.selectByPrimaryKey(requestDTO.getCode());
        if(taskBo==null){
            throw new MyBizException("任务不存在");
        }
        JobInfo jobInfo = obj2ObjMapper.map(taskBo, JobInfo.class);
        taskMapper.updateByPrimaryKeySelective(TaskBo.builder().code(requestDTO.getCode()).status(NormalStatus.DELETE.name()).build());
        schedulerAllJob.remove(jobInfo);
        return new BaseResponseDTO();
    }

    @Override
    public BaseResponseDTO controlTask(CodeRequestDTO requestDTO) {
        TaskBo taskBo = taskMapper.selectByPrimaryKey(requestDTO.getCode());
        if(taskBo==null){
            throw new MyBizException("任务不存在");
        }
        JobInfo jobInfo = obj2ObjMapper.map(taskBo, JobInfo.class);
        if(NormalStatus.DELETE.name().equals( taskBo.getStatus())){
            throw new MyBizException("任务状态为删除不可操作");
        }
        String status="";
        if(NormalStatus.USING.name().equals(taskBo.getStatus())){
            status=NormalStatus.DISABLE.name();
            schedulerAllJob.remove(jobInfo);
        }else{
            status=NormalStatus.USING.name();
            schedulerAllJob.add(jobInfo);
        }
        taskMapper.updateByPrimaryKeySelective(TaskBo.builder().code(requestDTO.getCode()).status(status).build());
        return new BaseResponseDTO();
    }

    @Override
    public TaskExeRecordResponseDTO getTaskExeRecords(TaskExeRecordRequestDTO recordRequestDTO) {
        TaskExeRecordDTO recordDTO = obj2ObjMapper.map(recordRequestDTO, TaskExeRecordDTO.class);
        Page<TaskExeRecord> taskExeRecords = PageHelper.startPage(recordRequestDTO.getPage(), recordRequestDTO.getSize());
        taskExeRecordMapper.selectTaskExeRecords(recordDTO);
        TaskExeRecordResponseDTO taskExeRecordResponseDTO=new TaskExeRecordResponseDTO();
        taskExeRecordResponseDTO.setRecordInfos(obj2ObjMapper.mapAsList(taskExeRecords.getResult(), TaskExeRecordInfo.class));
        taskExeRecordResponseDTO.setTotal(taskExeRecords.getTotal());
        return taskExeRecordResponseDTO;
    }
}
