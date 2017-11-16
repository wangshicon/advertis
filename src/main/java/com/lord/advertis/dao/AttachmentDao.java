package com.lord.advertis.dao;

import com.lord.advertis.base.BaseMapper;
import com.lord.advertis.domain.Attachment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentDao extends BaseMapper<Attachment, Integer>{

    public List<Attachment> findAll();

    public List<Attachment> findByCategoryId(Integer cid);

    public List<Attachment> selectBylimit(@Param("offset")Integer offset, @Param("limit")Integer limit);
}