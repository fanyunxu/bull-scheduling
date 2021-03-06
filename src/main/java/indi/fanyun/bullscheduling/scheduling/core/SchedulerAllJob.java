package indi.fanyun.bullscheduling.scheduling.core;

import com.alibaba.fastjson.JSON;
import indi.fanyun.bullscheduling.common.types.NormalStatus;
import indi.fanyun.bullscheduling.mapper.TaskMapper;
import indi.fanyun.bullscheduling.model.dbo.TaskBo;
import indi.fanyun.bullscheduling.model.info.JobInfo;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tshk
 * @date 2021-01-13 10:04
 */
@Component
@Slf4j
public class SchedulerAllJob {

    @Resource
    private SchedulerFactoryBean schedulerFactoryBean;
    @Resource
    private MapperFacade obj2ObjMapper;
    @Resource
    private TaskMapper taskMapper;
    /**
     * 该方法用来启动所有的定时任务
     * @throws SchedulerException
     */
    public void scheduleJobs() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
    }

    public void stop()  {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.clear();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void remove(JobInfo jobInfo)  {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            boolean deleteJob = scheduler.deleteJob(new JobKey(jobInfo.getCode(), HttpJob.JOB_GROUP));
            log.info("删除任务成功:{}",jobInfo.getTaskName());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void add(JobInfo jobInfo)  {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(HttpJob.class) .withIdentity(jobInfo.getCode(), HttpJob.JOB_GROUP).build();
            // 每5s执行一次
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo.getCron());
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobInfo.getCode(), HttpJob.JOB_GROUP) .withSchedule(scheduleBuilder).build();
            cronTrigger.getJobDataMap().put(HttpJob.JOB_KEY, JSON.toJSONString(jobInfo));
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    /**
     * 配置Job1
     * 此处的任务可以配置可以放到properties或者是放到数据库中
     * @param scheduler
     * @throws SchedulerException
     */
    private void scheduleJob1(Scheduler scheduler) {
        List<TaskBo> tasks = taskMapper.select(TaskBo.builder().status(NormalStatus.USING.name()).build());
        if(tasks != null && !tasks.isEmpty()){
            for (TaskBo task : tasks) {
                JobInfo jobInfo = obj2ObjMapper.map(task, JobInfo.class);
                JobKey jobKey = new JobKey(task.getCode(), HttpJob.JOB_GROUP);
                JobDetail jobDetail = JobBuilder.newJob(HttpJob.class) .withIdentity(jobKey).build();
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCron());
                CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(task.getCode(), HttpJob.JOB_GROUP) .withSchedule(scheduleBuilder).build();
                cronTrigger.getJobDataMap().put(HttpJob.JOB_KEY, JSON.toJSONString(jobInfo));
                try {
                    if (!scheduler.checkExists(jobKey)) {
                        scheduler.scheduleJob(jobDetail,cronTrigger);
                    }
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}