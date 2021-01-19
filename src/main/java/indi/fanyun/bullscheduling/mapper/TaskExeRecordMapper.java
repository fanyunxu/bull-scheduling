package indi.fanyun.bullscheduling.mapper;

import indi.fanyun.bullscheduling.model.dbo.TaskExeRecord;
import indi.fanyun.bullscheduling.model.dto.TaskExeRecordDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskExeRecordMapper extends Mapper<TaskExeRecord> {

    List<TaskExeRecord> selectTaskExeRecords(TaskExeRecordDTO recordDTO);
}