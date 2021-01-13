package indi.fanyun.bullscheduling.lisenter;

import indi.fanyun.bullscheduling.scheduling.core.SchedulerAllJob;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tshk
 * @date 2021-01-13 10:03
 */
@Component
public class QuartzInitLisenter implements ApplicationListener {

    @Resource
    private SchedulerAllJob schedulerAllJob;


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        try {
            schedulerAllJob.scheduleJobs();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}