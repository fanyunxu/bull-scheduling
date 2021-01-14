package indi.fanyun.bullscheduling.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-14 14:54
 */
@Getter
@Setter
@NoArgsConstructor
public class BasePageRequestDTO extends CodeRequestDTO{

    @ApiModelProperty("页")
    private Integer page=1;
    @ApiModelProperty("每页大小")
    private Integer size=20;
}
