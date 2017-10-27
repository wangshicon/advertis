package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Module;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleDao extends BaseMapper<Module, Integer>{

    public List<Module> findAll();

}