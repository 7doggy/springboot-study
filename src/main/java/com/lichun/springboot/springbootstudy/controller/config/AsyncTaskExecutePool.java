package com.lichun.springboot.springbootstudy.controller.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 */
@Slf4j
@Configuration
public class AsyncTaskExecutePool implements AsyncConfigurer {

    @Autowired
    private TaskThreadPoolConfig taskThreadPoolConfig;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(taskThreadPoolConfig.getCorePoolSize());
        executor.setMaxPoolSize(taskThreadPoolConfig.getMaxPoolSize());
        executor.setKeepAliveSeconds(taskThreadPoolConfig.getKeepAliveSeconds());
        executor.setQueueCapacity(taskThreadPoolConfig.getQueueCapacity());
        executor.setThreadNamePrefix(taskThreadPoolConfig.getThreadNamePrefix());
        //AbortPolicy :直接抛出 java.util.concurrent.RejectedExecutionException 异常 。
        //CallerRunsPolicy :主线程直接执行该任务,执行完之后尝试添加下一个任务到线程池中,这样可以有效降低向线程池内添加任务的速度 。
        //建议用 CallerRunsPolicy 策略,因为当队列中的任务满了之后,如果直接抛异常,那么这个任务就会被丢弃 。
        //如果是 CallerRunsPolicy 策略,则会用主线程去执行,就是同步执行,这样最起码任务不会被丢弃 。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                log.error("=====" + throwable.getMessage() + "=====", throwable);
                log.error("exception method ", method.getName());
            }
        };
    }
}

