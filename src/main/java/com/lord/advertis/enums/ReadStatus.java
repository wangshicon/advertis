package com.lord.advertis.enums;

/**
 * @author Lord
 * @version V1.0
 * @Description 浏览状态  已读1 未读0
 * @date 2017-11-17
 */
public enum ReadStatus {

    Read(1), Unread(0);

    private int value;

    public int getValue() {
        return value;
    }

    ReadStatus(int value) {
        this.value = value;
    }

}
