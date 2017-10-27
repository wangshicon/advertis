package com.lord.advertis.service.serviceimpl;

import com.lord.advertis.dao.UsersDao;
import com.lord.advertis.domain.Users;
import com.lord.advertis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @Description: 用户模块业务实现逻辑类
 * @author Lord
 * @date 2017年10月27日 下午3:06:31
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public int insert(Users users) {
        return usersDao.insertSelective(users);
    }

    @Override
    public int delete(Integer id) {
        return usersDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Users users) {
        return usersDao.updateByPrimaryKeySelective(users);
    }

    @Override
    public Users findById(Integer id) {
        return usersDao.selectByPrimaryKey(id);
    }
}
