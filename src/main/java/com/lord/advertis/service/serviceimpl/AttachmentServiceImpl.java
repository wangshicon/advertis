package com.lord.advertis.service.serviceimpl;

import com.lord.advertis.dao.AttachmentDao;
import com.lord.advertis.domain.Attachment;
import com.lord.advertis.enums.ResultEnum;
import com.lord.advertis.exception.AdvertisException;
import com.lord.advertis.service.AttachmentService;
import com.lord.advertis.utils.FileUtil;
import com.lord.advertis.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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

    @Override
    public List<Attachment> findByCategoryId(Integer cid) {
        return attachmentDao.findByCategoryId(cid);
    }

    @Override
    public List<Attachment> selectByLimit(Integer offset, Integer limit) {
        return attachmentDao.selectBylimit(offset, limit);
    }

    @Override
    public int uploadFile(MultipartFile[] files, Integer categoryId, String realPath, String filePath) {
        int flag = 0;
        if (files.length > 0){
            File pathFile = new File(realPath);     // realPath 物理文件存放地址
            if (!pathFile.exists()){
                //物理文件夹不存在 创建文件夹
                pathFile.mkdirs();
            }

            for (int i = 0; i < files.length; i++) {
                Attachment attachment = new Attachment();
                attachment.setFilename(files[i].getOriginalFilename());     // 源文件名称
                attachment.setAttname(UUIDUtil.generate()+ FileUtil.subSuffix(files[i].getOriginalFilename())); // 附件存在名称
                attachment.setFilesize((int) files[i].getSize());           // 文件大小
                attachment.setFilepath(filePath + files[i].getOriginalFilename()); // 页面访问文件路径
                attachment.setCid(categoryId);  // 所属分类
                try {
                    files[i].transferTo(new File(realPath + "/" + attachment.getAttname()));
                    flag = attachmentDao.insertSelective(attachment);       // 保存附件信息到数据库
                } catch (IOException e) {
                    throw new AdvertisException(ResultEnum.COPY_ERROR);
                }
            }
        }
        return flag;
    }
}
