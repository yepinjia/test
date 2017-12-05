package com.example.web;
/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月28日 上午11:48:02
* 
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@RequestMapping(value = "/getName", method = RequestMethod.GET)
	@ResponseBody
	public String getName() {

		ValueOperations<String, String> value = redisTemplate.opsForValue();
		
		value.set("name", "tom");
		
		return value.get("name");

	}

}
