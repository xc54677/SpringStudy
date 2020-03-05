package quartzDemo.job;

import org.quartz.*;
import quartzDemo.service.MeetingService;

import java.util.List;

public class PlanJob implements Job {

    MeetingService meetingService = new MeetingService();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println(triggerKey + "\n" + jobKey);

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        List<String> infos = (List<String>) jobDataMap.get("infos");
        System.out.println(infos);

        //存放计划执行的任务...
        meetingService.callClassMeeting();
    }
}
