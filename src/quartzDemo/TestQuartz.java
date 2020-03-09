package quartzDemo;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import quartzDemo.job.PlanJob;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestQuartz {

    public static void main(String[] args) throws SchedulerException, ParseException {
        quartzAndSpringTest();
    }

    public static void quartzAndSpringTest() throws SchedulerException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StdScheduler scheduleFactory = (StdScheduler)context.getBean("scheduleFactoryBean");
        scheduleFactory.start();
    }

    public static void quartzTest() throws SchedulerException {
        JobBuilder jobBuilder = JobBuilder.newJob(PlanJob.class);
        //产生实际使用的job
        JobDetail jobDetail = jobBuilder.withIdentity("meeting job", "group1").build();

        //如果想向job的execute()中传入一些参数，得按照一些约定
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        List<String> names = Arrays.asList(new String[]{"zs", "ls", "ww"});
        jobDataMap.put("infos", names);


        //触发器：时间规则，以来两个对象（TriggerBuilder, schedule）
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        TriggerBuilder<Trigger> triggerTriggerBuilder = triggerBuilder.withIdentity("meeting trigger", "group1");
        //一种开始，立刻开始
        triggerTriggerBuilder.startNow(); //当满足条件时立即执行

        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = dateFormat.parse("2020-03-05 22:17:30");
        Date endDate = dateFormat.parse("2020-03-05 22:17:45");
        //第二种，按照规定的时间内执行
        triggerTriggerBuilder.startAt(startDate);
        triggerTriggerBuilder.endAt(endDate);*/

        /*//scheduleBuilder定义执行的周期（时机）
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        scheduleBuilder.withIntervalInSeconds(1);//每隔一秒执行一次
        scheduleBuilder.withRepeatCount(10);//重复执行十次*/

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("5,10,15,30 * * * * ? *");

        //产生触发器
//        SimpleTrigger trigger = triggerTriggerBuilder.withSchedule(scheduleBuilder).build();
        CronTrigger trigger = triggerTriggerBuilder.withSchedule(cronScheduleBuilder).build();

        //调度器（工厂产生调度器）
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //产生调度器
        Scheduler scheduler = schedulerFactory.getScheduler();

        //通过调度器将任务和触发器一一对应
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

//        scheduler.shutdown(false);
    }

}
