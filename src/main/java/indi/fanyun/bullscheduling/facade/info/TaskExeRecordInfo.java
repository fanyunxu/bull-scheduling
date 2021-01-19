package indi.fanyun.bullscheduling.facade.info;

import com.fasterxml.jackson.annotation.JsonFormat;
import indi.fanyun.bullscheduling.common.types.ResultsStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-19 15:20
 */
@Data
public class TaskExeRecordInfo {

    private String code;

    /**
     * 任务编号
     */
    @ApiModelProperty("任务编号")
    private String taskCode;

    /**
     * 任务执行开始时间
     */
    @ApiModelProperty("任务执行开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtStart;

    /**
     * 任务执行结束时间
     */
    @ApiModelProperty("任务执行结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtEnd;

    /**
     * 执行结果
     */
    @ApiModelProperty("执行结果")
    private ResultsStatus results;

    /**
     * 执行返回体
     */
    @ApiModelProperty("执行返回体")
    private String resultBody;
}
