package indi.fanyun.bullscheduling.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.info.TaskInfo;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.facade.request.TaskQueryRequestDTO;
import indi.fanyun.bullscheduling.facade.response.TaskListResponseDTO;
import indi.fanyun.bullscheduling.mapper.TaskMapper;
import indi.fanyun.bullscheduling.model.dbo.TaskBo;
import indi.fanyun.bullscheduling.model.info.JobInfo;
import indi.fanyun.bullscheduling.model.info.TaskInfoDTO;
import indi.fanyun.bullscheduling.scheduling.core.SchedulerAllJob;
import indi.fanyun.bullscheduling.service.TaskService;
import ma.glasnost.orika.MapperFacade;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        try {
            schedulerAllJob.add(jobInfo);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
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
}
