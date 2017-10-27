package com.lord.advertis.domain;

import com.lord.advertis.base.BaseBean;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description: 用户信息实体
 * @author Lord
 * @date 2017年10月27日 上午9:06:53
 */
public class Users extends BaseBean {

    private static final long serialVersionUID = 8047492711952827696L;

    // 登录名
    @NotEmpty(message="登录名不能为空")
    private String loginname;

    // 密码
    @NotEmpty(message="密码不能为空")
    private String password;

    // 修改时间
    private Date updatetime;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}