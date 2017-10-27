package com.lord.advertis.base;

import java.io.Serializable;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 6243975440970933753L;
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
