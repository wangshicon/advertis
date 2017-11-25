package com.lord.advertis.service;

import com.lord.advertis.domain.Browse;

import java.util.List;

/**
 * 
 * @Description: 访问统计业务逻辑接口类
 * @author Lord
 * @date 2017年10月27日 下午2:51:32
 */
public interface BrowseService {
	
	 public int insert(Browse browse);
	 
	 public int delete(Integer id);
	 
	 public int update(Browse browse);
	 
	 public Browse findById(Integer id);

	 public List<Browse> findWeekCount();

}
