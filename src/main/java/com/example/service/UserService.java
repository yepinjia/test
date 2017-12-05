package com.example.service;

import java.util.List;

import com.example.domain.firstdomain.User;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月28日 上午11:46:59
* 
*/
public interface UserService {

	public List<User> findUser(int id);
}
