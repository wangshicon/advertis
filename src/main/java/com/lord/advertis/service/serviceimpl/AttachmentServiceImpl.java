package com.lord.advertis.service.serviceimpl;

import com.lord.advertis.dao.AttachmentDao;
import com.lord.advertis.domain.Attachment;
import com.lord.advertis.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @Description: 附件业务实现逻辑类
 * @author Lord
 * @date 2017年10月27日 下午3:06:31
 */
@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private AttachmentDao attachmentDao;

    @Override
    public int insert(Attachment attachment) {
        return attachmentDao.insertSelective(attachment);
    }

    @Override
    public int delete(Integer id) {
        return attachmentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Attachment attachment) {
        return attachmentDao.updateByPrimaryKeySelective(attachment);
    }

    @Override
    public Attachment findById(Integer id) {
        return attachmentDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Attachment> findAll() {
        return attachmentDao.findAll();
    }
}
