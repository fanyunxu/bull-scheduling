package indi.fanyun.bullscheduling.mapper;

import indi.fanyun.bullscheduling.model.dbo.TaskBo;
import indi.fanyun.bullscheduling.model.info.TaskInfoDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskMapper extends Mapper<TaskBo> {
    /**
     * 查询任务列表
     * @param taskInfoDTO
     * @return
     */
    List<TaskBo> selectByParam(TaskInfoDTO taskInfoDTO);
}