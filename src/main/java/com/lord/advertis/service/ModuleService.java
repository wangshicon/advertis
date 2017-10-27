package com.lord.advertis.service;

import com.lord.advertis.domain.Module;

import java.util.List;

/**
 * 
 * @Description: 页面模块业务逻辑接口类
 * @author Lord
 * @date 2017年10月27日 下午2:51:32
 */
public interface ModuleService {

	 public int insert(Module module);

	 public int delete(Integer id);
	 
	 public int update(Module module);
	 
	 public Module findById(Integer id);
	 
	 public List<Module> findAll();

}
