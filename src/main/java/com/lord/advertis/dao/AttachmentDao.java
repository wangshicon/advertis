package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Attachment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentDao extends BaseMapper<Attachment, Integer>{

    public List<Attachment> findAll();

    public List<Attachment> findByCategoryId(Integer cid);
}