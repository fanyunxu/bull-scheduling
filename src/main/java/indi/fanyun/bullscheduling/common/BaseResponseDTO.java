package indi.fanyun.bullscheduling.common;

import indi.fanyun.bullscheduling.common.types.ErrorTypes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-12 15:22
 */
@Setter
@Getter
public class BaseResponseDTO {

    @ApiModelProperty("是否成功")
    private boolean success=true;
    @ApiModelProperty("错误消息")
    private String errorMsg;
    @ApiModelProperty("错误类型")
    private ErrorTypes errorTypes;

    public void fail(ErrorTypes errorTypes){
        this.success=false;
        this.errorMsg=errorTypes.getErrorMsg();
        this.errorTypes=errorTypes;
    }
    public void fail(ErrorTypes errorTypes,String errorMsg){
        this.success=false;
        this.errorMsg=errorMsg;
        this.errorTypes=errorTypes;
    }
    public void fail(String errorMsg){
        this.success=false;
        this.errorMsg=errorMsg;
        this.errorTypes=ErrorTypes.SYSTEM_ERROR;
    }

}
