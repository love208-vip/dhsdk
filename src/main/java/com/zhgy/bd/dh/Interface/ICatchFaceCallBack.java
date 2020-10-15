package com.zhgy.bd.dh.Interface;

import com.zhgy.bd.dh.entity.FaceInfo;

/**
 * @Author nonin
 * @Date 2020/7/6
 * @description
 **/
public interface ICatchFaceCallBack {
    void catchFaceInvoke(String loginIP,int channel,FaceInfo faceInfo);
}
