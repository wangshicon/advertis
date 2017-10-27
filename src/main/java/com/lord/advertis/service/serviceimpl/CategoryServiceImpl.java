package com.lord.advertis.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lord.advertis.dao.CategoryDao;
import com.lord.advertis.domain.Category;
import com.lord.advertis.service.CategoryService;

/**
 * 
 * @Description: 分类业务实现逻辑类
 * @author Lord
 * @date 2017年10月27日 下午3:06:31
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public int insert(Category category) {
		return categoryDao.insertSelective(category);
	}

	@Override
	public int delete(Integer id) {
		return categoryDao.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Category category) {
		return categoryDao.updateByPrimaryKeySelective(category);
	}

	@Override
	public Category findById(Integer id) {
		return categoryDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
}
