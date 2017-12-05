package com.example.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.firstDao.UserDao;
import com.example.domain.firstdomain.User;
import com.example.service.UserService;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月21日 上午11:02:50
* 
*/
@Service
public class UserServiceImpl implements UserService{
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findUser(int id) {
		
		logger.info("调用查询功能！");
		
		return userDao.findUser(id);
	}

}
