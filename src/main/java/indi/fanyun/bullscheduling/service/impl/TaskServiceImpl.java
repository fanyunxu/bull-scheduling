package indi.fanyun.bullscheduling.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import indi.fanyun.bullscheduling.common.BaseResponseDTO;
import indi.fanyun.bullscheduling.facade.request.TaskEditRequestDTO;
import indi.fanyun.bullscheduling.mapper.TaskMapper;
import indi.fanyun.bullscheduling.model.dbo.TaskBo;
import indi.fanyun.bullscheduling.model.info.JobInfo;
import indi.fanyun.bullscheduling.scheduling.core.SchedulerAllJob;
import indi.fanyun.bullscheduling.service.TaskService;
import ma.glasnost.orika.MapperFacade;
import org.quartz.SchedulerException;
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
}
