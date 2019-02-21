package com.example.demo.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QuartzTest {
	@Test
	public void test1() throws SchedulerException {
		// 1.创建 Job 对象：你要做什么事？
		JobDetail job = JobBuilder.newJob(MyJob2.class).build();

		/**
		 * 简单的 trigger 触发时间：通过 Quartz 提供一个方法来完成简单的重复 调用 cron Trigger：按照 Cron
		 * 的表达式来给定触发的时间
		 */
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
				.build();
		// 3.创建 Scheduler 对象：在什么时间做什么事？
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);
		
		//启动
		scheduler.start();
	}
}
