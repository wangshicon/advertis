package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Customers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersDao extends BaseMapper<Customers, Integer>{

    public List<Customers> findAll();

    public List<Customers> selectBylimit(@Param("offset")Integer offset, @Param("limit")Integer limit);

    public Integer findTotalByState(Integer status);
}