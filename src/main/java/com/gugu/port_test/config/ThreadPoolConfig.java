package com.gugu.port_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author minmin
 * @since 2021/05/07 23:26
 */
@Configuration
public class ThreadPoolConfig {
    @Bean
    ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(processors);
        threadPoolTaskExecutor.setMaxPoolSize(processors * 2);
        threadPoolTaskExecutor.setThreadNamePrefix("blog-task-process");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
