package kr.or.connect.config;

import java.util.concurrent.*;

import org.springframework.aop.interceptor.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.*;

@Configuration
@EnableAsync
public class AsyncFileConfig implements AsyncConfigurer {
	
	private static ThreadPoolTaskExecutor taskExecutor;
	private static int TASK_CORE_POOL_SIZE = 2;
	private static int TASK_MAX_POOL_SIZE = 2;
	private static int TASK_QUEUE_CAPACITY = 10;

	@Bean(name = "taskExecutor")
	@Override
	public Executor getAsyncExecutor() {
		taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(TASK_CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(TASK_MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(TASK_QUEUE_CAPACITY);
        taskExecutor.setBeanName("taskExecutor");
        taskExecutor.initialize();
        return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
