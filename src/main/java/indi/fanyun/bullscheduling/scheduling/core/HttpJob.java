package indi.fanyun.bullscheduling.scheduling.core;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import indi.fanyun.bullscheduling.common.types.ParamType;
import indi.fanyun.bullscheduling.common.types.ResultsStatus;
import indi.fanyun.bullscheduling.model.info.JobExeRecordInfo;
import indi.fanyun.bullscheduling.model.info.JobInfo;
import indi.fanyun.bullscheduling.scheduling.util.TaskUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @author tshk
 * @date 2021-01-12 17:38
 */
public class HttpJob implements Job {

    public static final String JOB_KEY="JOB_INFO";
    public static final String JOB_GROUP="JOB_GROUP";

    @Override
    public void execute(JobExecutionContext jobExecutionContext)  {
        JobInfo jobInfo = JSON.parseObject(jobExecutionContext.getTrigger().getJobDataMap().getString(JOB_KEY), JobInfo.class);
        HttpRequest request=new HttpRequest(jobInfo.getTargetUrl());
        request.method(jobInfo.getMethod());
        long start=System.currentTimeMillis();
        if(ParamType.JSON.equals(jobInfo.getParamType())){
            if(StrUtil.isBlank(jobInfo.getParam())){
                request.body("{}");
            }else{
                request.body(jobInfo.getParam());
            }
        }
        HttpResponse response = request.execute();
        String body = response.body();
        JobExeRecordInfo exeRecordInfo=new JobExeRecordInfo();
        exeRecordInfo.setGmtStart(new Date(start));
        exeRecordInfo.setGmtEnd(new Date());
        exeRecordInfo.setTaskCode(jobInfo.getCode());
        exeRecordInfo.setResultBody(getBody(body));
        exeRecordInfo.setResults(response.getStatus()==200? ResultsStatus.USING.name():ResultsStatus.ABNORMAL.name());
        TaskUtil.addTaskExeRecord(exeRecordInfo);
    }
    private String getBody(String data){
        if(data==null){
            return data;
        }
        return data.length()>512?data.substring(0,512):data;
    }
}
