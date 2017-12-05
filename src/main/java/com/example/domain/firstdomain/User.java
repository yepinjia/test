package com.example.domain.firstdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年5月27日 上午9:25:29
* 
*/
@ApiModel("用户实体")
public class User {
	
	@ApiModelProperty(value="主键")
	private Integer id;
	
	@ApiModelProperty(value="姓名")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
