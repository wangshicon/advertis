package com.lord.advertis.domain;

import com.lord.advertis.base.BaseBean;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description: 分类信息实体
 * @author Lord
 * @date 2017年10月27日 上午9:06:53
 */
public class Category extends BaseBean {

    private static final long serialVersionUID = 3290193170114232723L;

    // 分类名称
    @NotEmpty(message="分类名称不能为空")
    private String name;

    // 状态
    private Integer status;

    // 修改时间
    private Date createtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}