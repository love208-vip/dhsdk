package com.zhgy.bd.dh.Interface;

import com.zhgy.bd.dh.entity.FaceInfo;

/**
 * @Author nonin
 * @Date 2020/7/1
 * @description
 **/
public interface IReceiveFaceCallBack {
    void receiveFaceInvoke(String clientId,long loginID,long attachHandle,FaceInfo faceInfo);
}
