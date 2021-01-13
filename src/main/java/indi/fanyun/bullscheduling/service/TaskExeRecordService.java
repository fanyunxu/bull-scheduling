package indi.fanyun.bullscheduling.service;

import indi.fanyun.bullscheduling.model.info.JobExeRecordInfo;

/**
 * @author tshk
 * @date 2021-01-13 13:50
 */
public interface TaskExeRecordService {
    /**
     * 添加执行记录
     * @param recordInfo
     * @return
     */
    Integer addRecord(JobExeRecordInfo recordInfo);
}
