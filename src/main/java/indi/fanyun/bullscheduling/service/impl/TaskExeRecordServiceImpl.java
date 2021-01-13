package indi.fanyun.bullscheduling.service.impl;

import cn.hutool.crypto.SecureUtil;
import indi.fanyun.bullscheduling.mapper.TaskExeRecordMapper;
import indi.fanyun.bullscheduling.model.dbo.TaskExeRecord;
import indi.fanyun.bullscheduling.model.info.JobExeRecordInfo;
import indi.fanyun.bullscheduling.service.TaskExeRecordService;
import indi.fanyun.bullscheduling.service.TaskService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-13 13:51
 */
@Service
@Transactional
public class TaskExeRecordServiceImpl implements TaskExeRecordService {

    @Resource
    private TaskExeRecordMapper taskExeRecordMapper;
    @Resource
    private MapperFacade obj2ObjMapper;

    @Override
    public Integer addRecord(JobExeRecordInfo recordInfo) {
        TaskExeRecord taskExeRecord=obj2ObjMapper.map(recordInfo,TaskExeRecord.class);
        taskExeRecord.setCode(SecureUtil.md5("job_record"+System.currentTimeMillis()));
        taskExeRecord.setGmtCreate(new Date());
        return taskExeRecordMapper.insertSelective(taskExeRecord);
    }
}
