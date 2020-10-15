package com.zhgy.bd.dh;

import com.zhgy.bd.dh.Interface.IVideoStatCallBack;

public class TestVideoStat implements IVideoStatCallBack {
    @Override
    public void videoStatInvoke(int todayEnter, int todayExit) {
        System.out.println("todayEnter:"+todayEnter);
        System.out.println("todayExit:"+todayExit);
    }
}
