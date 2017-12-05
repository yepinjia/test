package com.example.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.firstdomain.User;
import com.example.listener.StartupRunner;
import com.example.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @discription
 * @author 作者 yepinjia
 * @version 创建时间：2017年5月25日 下午2:35:40
 * 
 */
@Api(value="HelloController", description="用户信息接口")
@RestController
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private UserService userService;

	@ApiOperation(value="根据主键查询")
	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findUser( @ApiParam(value="主键" ,required=true) @RequestParam Integer id){
		
		return userService.findUser(id);
		
	}
	
	@ApiOperation(value="根据主键查询")
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public Integer find(){
		
		try {
			
			int j = 1;
			
			int k = 5/j;
			
		} catch (Exception e) {
			
			logger.error("错误日志", e);
		}
		
		return 1;
	}
	
	
	@ApiOperation(value="测试")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(){
		
		return "Hello world";
	}
}
