package indi.fanyun.bullscheduling.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import indi.fanyun.bullscheduling.facade.info.LabelInfo;
import indi.fanyun.bullscheduling.facade.info.LabelResponseDTO;
import indi.fanyun.bullscheduling.mapper.TaskGroupMapper;
import indi.fanyun.bullscheduling.model.dbo.TaskGroup;
import indi.fanyun.bullscheduling.service.TaskGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tshk
 * @date 2021-01-26 17:04
 */
@Service
@Transactional
public class TaskGroupServiceImpl implements TaskGroupService {

    @Resource
    private TaskGroupMapper taskGroupMapper;


    @Override
    public LabelResponseDTO getGroups(BaseRequestDTO requestDTO) {
        List<TaskGroup> taskGroups = taskGroupMapper.select(TaskGroup.builder().status(NormalStatus.USING.name()).build());
        if(CollectionUtil.isEmpty(taskGroups)){
            return new LabelResponseDTO();
        }
        LabelResponseDTO labelResponseDTO = new LabelResponseDTO();
        List<LabelInfo> labelInfos = taskGroups.stream().map(m -> LabelInfo.builder().lable(m.getGroupName()).value(m.getCode()).build()).collect(Collectors.toList());
        labelResponseDTO.setLabelInfos(labelInfos);
        return labelResponseDTO;
    }
}
