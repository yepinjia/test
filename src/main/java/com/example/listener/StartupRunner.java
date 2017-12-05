package com.example.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动时执行
 * @author deen ye
 *
 */
@Component
@Order(value=2)//执行的时机、2为启动后
public class StartupRunner implements CommandLineRunner {
	
	private static Logger logger = LoggerFactory.getLogger(StartupRunner.class);
	
    @Override
    public void run(String... args) throws Exception {
    	logger.info("系统启动完成了！");
    }

}
