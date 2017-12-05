package com.example.dao.firstDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.firstdomain.User;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月21日 上午10:53:41
* 
*/
@Repository
public interface UserDao {
	
	List<User> findUser(@Param("id") Integer id);

}
