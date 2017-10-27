package com.lord.advertis.domain;

import com.lord.advertis.base.BaseBean;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description: 页面模块实体
 * @author Lord
 * @date 2017年10月27日 上午9:06:53
 */
public class Module extends BaseBean {

    private static final long serialVersionUID = -1244551374945857154L;

    // 名称
    @NotEmpty(message="名称不能为空")
    private String name;

    // 描述
    @NotEmpty(message="描述不能为空")
    private String desction;

    // 创建时间
    private Date createtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesction() {
        return desction;
    }

    public void setDesction(String desction) {
        this.desction = desction == null ? null : desction.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}