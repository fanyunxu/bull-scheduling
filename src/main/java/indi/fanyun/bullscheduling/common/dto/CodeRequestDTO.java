package indi.fanyun.bullscheduling.common.dto;

import indi.fanyun.bullscheduling.common.group.CodeGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author tshk
 * @date 2021-01-14 14:55
 */
@Getter
@Setter
@NoArgsConstructor
public class CodeRequestDTO extends BaseRequestDTO{

    @ApiModelProperty("code")
    @NotBlank(message = "code不得为空",groups = CodeGroup.class)
    private String code;
}
