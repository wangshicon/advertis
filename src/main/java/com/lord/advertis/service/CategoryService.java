package com.lord.advertis.service;

import java.util.List;

import com.lord.advertis.domain.Category;

/**
 * 
 * @Description: 分类业务逻辑接口类
 * @author Lord
 * @date 2017年10月27日 下午2:51:32
 */
public interface CategoryService {
	
	 public int insert(Category category);
	 
	 public int delete(Integer id);
	 
	 public int update(Category category);
	 
	 public Category findById(Integer id);
	 
	 public List<Category> findAll();

}
