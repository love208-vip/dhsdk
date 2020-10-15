package com.zhgy.bd.dh.Interface;

import com.dahua.netsdk.NetSDKLib;
import com.sun.jna.Pointer;

public class VideoStatSumImpl implements NetSDKLib.fVideoStatSumCallBack{

    private IVideoStatCallBack callBack;

    public IVideoStatCallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(IVideoStatCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void invoke(NetSDKLib.LLong lAttachHandle, NetSDKLib.NET_VIDEOSTAT_SUMMARY pBuf, int dwBufLen, Pointer dwUser) {
        if (callBack!=null){
            System.out.println("通道号："+ pBuf.nChannelID);
            callBack.videoStatInvoke(pBuf.stuEnteredSubtotal.nToday,pBuf.stuExitedSubtotal.nToday);
        }
    }
}
