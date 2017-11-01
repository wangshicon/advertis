package com.lord.advertis.domain;

import com.lord.advertis.base.BaseBean;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description: 客户意向实体
 * @author Lord
 * @date 2017年10月27日 上午9:06:53
 */
public class Customers extends BaseBean {

    private static final long serialVersionUID = 9035917417029867892L;

    // 姓名
    @NotEmpty(message="姓名不能为空")
    private String username;

    // 邮箱
    @NotEmpty(message="邮箱不能为空")
    private String email;

    // 电话
    @NotEmpty(message="电话不能为空")
    private String phone;

    // 信息
    private String message;

    // 创建时间
    private Date createtime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}