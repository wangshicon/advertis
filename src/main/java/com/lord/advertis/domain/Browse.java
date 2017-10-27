package com.lord.advertis.domain;

import com.lord.advertis.base.BaseBean;

import java.util.Date;

/**
 * @Description: 访问量统计实体
 * @author Lord
 * @date 2017年10月27日 上午9:06:53
 */
public class Browse extends BaseBean {

    private static final long serialVersionUID = 6996550159911336826L;

    // 日期
    private Date createdate;

    // 数量
    private Integer number;

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}