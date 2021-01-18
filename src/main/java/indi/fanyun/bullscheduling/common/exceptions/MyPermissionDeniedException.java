package indi.fanyun.bullscheduling.common.exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-18 17:36
 */
@Getter
@Setter
public class MyPermissionDeniedException extends RuntimeException {

    @ApiModelProperty("错误提示消息")
    private String message;

    public MyPermissionDeniedException(String messgae){
        this.message=messgae;
    }
}
