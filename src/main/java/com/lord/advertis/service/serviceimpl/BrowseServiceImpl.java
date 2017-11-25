package com.lord.advertis.service.serviceimpl;

import com.lord.advertis.dao.BrowseDao;
import com.lord.advertis.domain.Browse;
import com.lord.advertis.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @Description: 访问统计业务实现逻辑类
 * @author Lord
 * @date 2017年10月27日 下午3:06:31
 */
@Service
public class BrowseServiceImpl implements BrowseService {

	@Autowired
	private BrowseDao browseDao;

	@Override
	public int insert(Browse browse) {
		return browseDao.insertSelective(browse);
	}

	@Override
	public int delete(Integer id) {
		return browseDao.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Browse browse) {
		return browseDao.updateByPrimaryKeySelective(browse);
	}

	@Override
	public Browse findById(Integer id) {
		return browseDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Browse> findWeekCount() {
		return browseDao.findWeekCount();
	}
}
