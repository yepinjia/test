package com.example.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月29日 上午11:42:55
* 
*/
public class Test {
	
	
	public static void main(String[] args) {
		
		List<User> list = new ArrayList<>(5);
		User u1 = new User(1, "a");
		User u2 = new User(2, "b");
		User u3 = new User(2, "c");
		User u4 = new User(3, "d");
		User u5 = new User(5, "e");
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		list.add(u5);
		
		Map<Integer, String> map = new HashMap<>();
		
		for (User u : list) {
			
			map.put(u.getNum(), u.getName());
			
		}
		
		System.out.println(map.keySet());
		System.out.println(map.get(2));
	}

}

class User{
	
	private int num;
	private String name;
	
	public User(int num,String name){
		
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
