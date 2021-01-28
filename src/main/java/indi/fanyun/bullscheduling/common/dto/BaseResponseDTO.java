package indi.fanyun.bullscheduling.common.dto;

import indi.fanyun.bullscheduling.common.types.ErrorTypes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author tshk
 * @date 2021-01-12 15:22
 */
@Setter
@Getter
@NoArgsConstructor
public class BaseResponseDTO {

    @ApiModelProperty("是否成功")
    private boolean success=true;
    @ApiModelProperty("错误消息")
    private String errorMsg;
    @ApiModelProperty("错误类型")
    private ErrorTypes errorTypes;
    @ApiModelProperty("状态码")
    private Integer rstCode=0;

    public void fail(ErrorTypes errorTypes){
        this.success=false;
        this.errorMsg=errorTypes.getErrorMsg();
        this.errorTypes=errorTypes;
    }
    public void fail(ErrorTypes errorTypes,String errorMsg){
        this.success=false;
        this.errorMsg=errorMsg;
        this.errorTypes=errorTypes;
        this.rstCode=errorTypes.getErrorCode();
    }
    public void fail(String errorMsg){
        this.success=false;
        this.errorMsg=errorMsg;
        this.errorTypes=ErrorTypes.SYSTEM_ERROR;
    }

}
