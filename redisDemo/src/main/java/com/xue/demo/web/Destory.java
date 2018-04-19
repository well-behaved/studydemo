package com.xue.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * 结束时打印内存使用情况测试
 * @author xue
 */

@Component 
public class Destory {
	private static final Logger LOGGER = LoggerFactory.getLogger(Destory.class);
	 @PreDestroy  
	    public void destory() { 
		 LOGGER.error("服务器被关闭开始，关闭时间："+new Date());
		 Runtime run = Runtime.getRuntime();
		// 获取内存使用量
		 long startMem = run.totalMemory()-run.freeMemory();
		 LOGGER.error("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + startMem );
		 LOGGER.error("服务器被关闭结束，关闭时间："+new Date());
	        
	    }  
}
