package com.zhgy.bd.dh.Interface;

import com.dahua.netsdk.NetSDKLib;

/**
 * @Author nonin
 * @Date 2020/7/1
 * @description
 **/
public interface IReConnectCallBack{
    void reConnectInvoke(long loginID,String ip,int port);
}
