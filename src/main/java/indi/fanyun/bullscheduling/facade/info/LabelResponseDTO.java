package indi.fanyun.bullscheduling.facade.info;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tshk
 * @date 2021-01-26 14:51
 */
@Data
public class LabelResponseDTO extends BaseResponseDTO {

    private List<LabelInfo> labelInfos=new ArrayList<>();

}
