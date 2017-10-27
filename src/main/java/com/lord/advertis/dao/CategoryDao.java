package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Category;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends BaseMapper<Category, Integer>{

    public List<Category> findAll();
}