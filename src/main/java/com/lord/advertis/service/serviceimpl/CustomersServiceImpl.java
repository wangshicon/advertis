package com.lord.advertis.service.serviceimpl;

import com.lord.advertis.dao.CustomersDao;
import com.lord.advertis.domain.Customers;
import com.lord.advertis.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @Description: 客户意向业务实现逻辑类
 * @author Lord
 * @date 2017年10月27日 下午3:06:31
 */
@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersDao customersDao;

	@Override
	public int insert(Customers customers) {
		return customersDao.insertSelective(customers);
	}

	@Override
	public int delete(Integer id) {
		return customersDao.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Customers customers) {
		return customersDao.updateByPrimaryKeySelective(customers);
	}

	@Override
	public Customers findById(Integer id) {
		return customersDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Customers> findAll() {
		return customersDao.findAll();
	}

	@Override
	public List<Customers> selectByLimit(Integer offset, Integer limit) {
		return customersDao.selectBylimit(offset, limit);
	}

}
