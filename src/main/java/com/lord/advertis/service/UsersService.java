package com.lord.advertis.service;

import com.lord.advertis.domain.Users;

/**
 * 
 * @Description: 用户业务逻辑接口类
 * @author Lord
 * @date 2017年10月27日 下午2:51:32
 */
public interface UsersService {

	 public int insert(Users users);

	 public int delete(Integer id);
	 
	 public int update(Users users);
	 
	 public Users findById(Integer id);
	 
}
