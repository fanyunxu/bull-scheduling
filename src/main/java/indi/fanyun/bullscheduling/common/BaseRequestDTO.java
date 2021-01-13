package indi.fanyun.bullscheduling.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-12 15:46
 */
@Setter
@Getter
public class BaseRequestDTO {

    @ApiModelProperty("操作人id")
    private String operateId;
    @ApiModelProperty("操作人姓名")
    private String operateName;
}
