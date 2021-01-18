package indi.fanyun.bullscheduling.lisenter;

import indi.fanyun.bullscheduling.scheduling.core.SchedulerAllJob;
import org.quartz.SchedulerException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tshk
 * @date 2021-01-13 10:03
 */
@Component
public class QuartzInitLisenter implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private SchedulerAllJob schedulerAllJob;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        schedulerAllJob.scheduleJobs();
    }
}