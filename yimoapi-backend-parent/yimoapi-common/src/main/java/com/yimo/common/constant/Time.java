package com.yimo.common.constant;


/**
 * @Author: 刘呈
 * @Date: 2023/02/23/18:50
 * @Description: 时间常量类
 */
public enum Time {
    ONE_SECOND(1000),
    ONE_MINUTE(1000*60),
    ONE_HOUR(1000*60*60);
    private final long millisecond;
    Time(long millisecond){
        this.millisecond = millisecond;
    }

    public long getTime(){
        return millisecond;
    }
}
