package com.lord.advertis.common;

/**
 * @Description: 分页参数
 * @author Lord
 * @date 2017年5月26日 上午9:37:59
 */
public enum PageSize {
    
    ONE(1),ThREE(3),FIVE(5),SIX(6),EIGHT(8),TEN(10),TWOTEEN(12),SIXTEEN(16);
    
    private int size;
    
    PageSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }

}
