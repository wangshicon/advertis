package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao extends BaseMapper<Users, Integer>{

    public List<Users> findAll();

    public Users findByLoginName(String loginname);

}