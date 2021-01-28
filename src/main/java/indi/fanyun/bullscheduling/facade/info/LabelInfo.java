package indi.fanyun.bullscheduling.facade.info;

import lombok.Builder;
import lombok.Data;

/**
 * @author tshk
 * @date 2021-01-26 14:51
 */
@Data
@Builder
public class LabelInfo {

    private String lable;

    private String value;
}
