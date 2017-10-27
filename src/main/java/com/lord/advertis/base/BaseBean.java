package com.lord.advertis.base;

import java.io.Serializable;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 6243975440970933753L;
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
