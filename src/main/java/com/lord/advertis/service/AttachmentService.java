package com.lord.advertis.service;

import com.lord.advertis.domain.Attachment;

import java.util.List;

/**
 * 
 * @Description: 附件业务逻辑接口类
 * @author Lord
 * @date 2017年10月27日 下午2:51:32
 */
public interface AttachmentService {
	
	 public int insert(Attachment attachment);
	 
	 public int delete(Integer id);
	 
	 public int update(Attachment attachment);
	 
	 public Attachment findById(Integer id);
	 
	 public List<Attachment> findAll();

}