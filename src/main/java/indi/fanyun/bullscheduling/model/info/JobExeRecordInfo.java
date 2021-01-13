package indi.fanyun.bullscheduling.model.info;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-13 13:53
 */
@Data
public class JobExeRecordInfo {


    /**
     * 任务编号
     */
    private String taskCode;

    /**
     * 任务执行开始时间
     */
    private Date gmtStart;

    /**
     * 任务执行结束时间
     */
    private Date gmtEnd;

    /**
     * 执行结果
     */
    private String results;

    /**
     * 执行返回体
     */
    private String resultBody;

}
