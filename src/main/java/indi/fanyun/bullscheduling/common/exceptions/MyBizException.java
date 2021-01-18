package indi.fanyun.bullscheduling.common.exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-12 15:33
 */
@Getter
@Setter
public class MyBizException extends RuntimeException {

    @ApiModelProperty("错误提示消息")
    private String message;

    public MyBizException(String messgae){
        this.message=messgae;
    }
}
