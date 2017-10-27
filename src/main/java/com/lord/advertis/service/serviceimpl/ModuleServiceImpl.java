package com.lord.advertis.service.serviceimpl;

import com.lord.advertis.dao.CustomersDao;
import com.lord.advertis.dao.ModuleDao;
import com.lord.advertis.domain.Customers;
import com.lord.advertis.domain.Module;
import com.lord.advertis.service.CustomersService;
import com.lord.advertis.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @Description: 页面模块业务实现逻辑类
 * @author Lord
 * @date 2017年10月27日 下午3:06:31
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public int insert(Module module) {
        return moduleDao.insertSelective(module);
    }

    @Override
    public int delete(Integer id) {
        return moduleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Module module) {
        return moduleDao.updateByPrimaryKeySelective(module);
    }

    @Override
    public Module findById(Integer id) {
        return moduleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Module> findAll() {
        return moduleDao.findAll();
    }

}
