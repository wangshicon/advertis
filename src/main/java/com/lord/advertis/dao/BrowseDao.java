package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Attachment;
import com.lord.advertis.domain.Browse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrowseDao extends BaseMapper<Browse, Integer>{

    public List<Browse> findWeekCount();

}