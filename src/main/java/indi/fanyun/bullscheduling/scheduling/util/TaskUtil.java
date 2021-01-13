package indi.fanyun.bullscheduling.scheduling.util;

import indi.fanyun.bullscheduling.model.info.JobExeRecordInfo;
import indi.fanyun.bullscheduling.service.TaskExeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tshk
 * @date 2021-01-13 13:59
 */
@Component
public class TaskUtil {

    private static TaskExeRecordService taskExeRecordService;

    @Autowired
    public  void setTaskExeRecordService(TaskExeRecordService taskExeRecordService) {
        TaskUtil.taskExeRecordService = taskExeRecordService;
    }

    public static  void addTaskExeRecord(JobExeRecordInfo recordInfo){
        taskExeRecordService.addRecord(recordInfo);
    }
}
