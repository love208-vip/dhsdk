package com.zhgy.bd.dh.Interface;

import com.dahua.netsdk.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @Author nonin
 * @Date 2020/7/1
 * @description
 **/
public class DisConnectImpl implements NetSDKLib.fDisConnect {

    private IDisConnectCallBack disConnectCallBack;

    public DisConnectImpl(IDisConnectCallBack disConnectCallBack) {
        this.disConnectCallBack = disConnectCallBack;
    }

    @Override
    public void invoke(NetSDKLib.LLong lLoginID, String pchDVRIP, int nDVRPort, Pointer dwUser) {
        if (disConnectCallBack!=null){
            disConnectCallBack.disConnectInvoke(lLoginID.longValue(),pchDVRIP,nDVRPort);
        }
    }
}
