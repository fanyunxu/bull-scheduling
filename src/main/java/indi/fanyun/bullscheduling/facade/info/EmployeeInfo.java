package indi.fanyun.bullscheduling.facade.info;

import indi.fanyun.bullscheduling.common.types.NormalStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-18 11:51
 */
@Data
public class EmployeeInfo {


    private String code;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 状态 参考NormalStatus
     */
    @ApiModelProperty("状态")
    private NormalStatus status;
}
