package com.zhgy.bd.dh.Interface;

import com.dahua.netsdk.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @Author nonin
 * @Date 2020/7/1
 * @description
 **/
public class HaveReConnectImpl implements NetSDKLib.fHaveReConnect {
    private IReConnectCallBack reConnectCallBack;

    public HaveReConnectImpl(IReConnectCallBack reConnectCallBack) {
        this.reConnectCallBack = reConnectCallBack;
    }

    @Override
    public void invoke(NetSDKLib.LLong lLoginID, String pchDVRIP, int nDVRPort, Pointer dwUser) {
        if (reConnectCallBack!=null){
            reConnectCallBack.reConnectInvoke(lLoginID.longValue(),pchDVRIP,nDVRPort);
        }
    }
}
