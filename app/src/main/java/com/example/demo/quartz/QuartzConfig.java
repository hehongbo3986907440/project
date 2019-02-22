package com.example.demo.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {
//	@Bean
//	public JobDetailFactoryBean getDetailFactoryBean(){
//		JobDetailFactoryBean j = new JobDetailFactoryBean();
//		j.setJobClass(MyJob1.class);
//		return j;
//	}
	
	@Bean
	public JobDetailFactoryBean getDetailFactoryBean2(){
		JobDetailFactoryBean j = new JobDetailFactoryBean();
		j.setJobClass(MyJob2.class);
		return j;
	}
	@Bean
	public SimpleTriggerFactoryBean getSimpleTriggerFactoryBean(JobDetailFactoryBean j){
		SimpleTriggerFactoryBean s = new SimpleTriggerFactoryBean();
		s.setJobDetail(j.getObject());
		s.setRepeatInterval(2000);
		return s;
	}
	@Bean
	public CronTriggerFactoryBean getCronTriggerFactoryBean(JobDetailFactoryBean j){
		CronTriggerFactoryBean c = new CronTriggerFactoryBean();
		c.setJobDetail(j.getObject());
		c.setCronExpression("15 30 * * * ?");
		return c;
	}
	
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean(CronTriggerFactoryBean c){
		SchedulerFactoryBean sf = new SchedulerFactoryBean();
		sf.setTriggers(c.getObject());
		return sf;
	}
}
