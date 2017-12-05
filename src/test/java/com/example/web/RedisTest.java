package com.example.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.HelloApplication;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月28日 上午9:57:54
* 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(HelloApplication.class)
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void test() throws Exception {
		
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

}
