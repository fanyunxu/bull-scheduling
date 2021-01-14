package indi.fanyun.bullscheduling.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-14 15:05
 */
@Getter
@Setter
@NoArgsConstructor
public class BasePageResponseDTO extends BaseResponseDTO {

    @ApiModelProperty("总条数")
    private Long total;
}
