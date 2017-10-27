package com.lord.advertis.service;

import com.lord.advertis.domain.Customers;

import java.util.List;

/**
 * 
 * @Description: 客户意向业务逻辑接口类
 * @author Lord
 * @date 2017年10月27日 下午2:51:32
 */
public interface CustomerService {

	 public int insert(Customers customers);

	 public int delete(Integer id);
	 
	 public int update(Customers customers);
	 
	 public Customers findById(Integer id);
	 
	 public List<Customers> findAll();

}
