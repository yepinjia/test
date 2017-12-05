package com.example.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年8月1日 下午4:05:02
* 
*/
public class DateUtilsTest {
	
	public static void main(String[] args) {
		
		Date now = new Date();
		String dateStr = DateFormatUtils.format(DateUtils.truncate(now, 3), "yyyy-MM-dd HH:mm:ss:SSS");
		
//		Date d = DateUtils.truncate(date, field)
		
		
		System.out.println(dateStr);
	}
	
	
}
