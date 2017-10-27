package com.lord.advertis.domain;

import com.lord.advertis.base.BaseBean;

/**
 * @Description: 附件储存实体
 * @author Lord
 * @date 2017年5月23日 上午9:06:53
 */
public class Attachment extends BaseBean {

    private static final long serialVersionUID = 6594431436973572619L;

    // 文件名称
    private String filename;

    // 附件存储名称
    private String attname;

    // 文件地址
    private String filepath;

    // 文件大小
    private Integer filesize;

    // 分类id
    private Integer cid;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}