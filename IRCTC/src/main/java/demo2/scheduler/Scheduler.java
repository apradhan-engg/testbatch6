package demo2.scheduler;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import demo2.utility.Cache;

@Component
@EnableScheduling
public class Scheduler {
	
	@Autowired
	Cache cache;
	
	@Scheduled(initialDelay = 15, fixedRate = 15, timeUnit = TimeUnit.SECONDS)
	public void m1()
	{
		cache.clearCache();
	}
	
	
	

}
