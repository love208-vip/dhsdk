package com.zhgy.bd.dh.Interface;

import com.dahua.netsdk.NetSDKLib;
import com.dahua.netsdk.ToolKits;
import com.sun.jna.Pointer;
import com.zhgy.bd.dh.entity.FaceInfo;

/**
 * @Author nonin
 * @Date 2020/7/6
 * @description
 **/
public class AnalyzerDataImpl implements NetSDKLib.fAnalyzerDataCallBack{

    private Module module;
    private ICatchFaceCallBack catchFaceCallBack;

    public AnalyzerDataImpl(Module module,ICatchFaceCallBack catchFaceCallBack) {
        this.module=module;
        this.catchFaceCallBack = catchFaceCallBack;
    }

    @Override
    public int invoke(NetSDKLib.LLong lAnalyzerHandle, int dwAlarmType, Pointer pAlarmInfo, Pointer pBuffer, int dwBufSize, Pointer dwUser, int nSequence, Pointer reserved){
        if (lAnalyzerHandle.longValue() == 0 || pAlarmInfo == null) {
            return -1;
        }

        switch(dwAlarmType)
        {
            case NetSDKLib.EVENT_IVS_FACERECOGNITION:  ///< 人脸识别事件
            {
                NetSDKLib.DEV_EVENT_FACERECOGNITION_INFO msg = new NetSDKLib.DEV_EVENT_FACERECOGNITION_INFO();

                // 耗时20ms左右
                ToolKits.GetPointerData(pAlarmInfo, msg);
                try{
                     FaceInfo faceInfo = new FaceInfo(
                             new String(msg.stuCandidatesEx[0].stPersonInfo.szGroupID, "GBK").trim(),
                             new String(msg.stuCandidatesEx[0].stPersonInfo.szUID, "GBK").trim(),
                             String.valueOf(msg.stuCandidatesEx[0].bySimilarity));
                    module.getDeviceInfo();
                    catchFaceCallBack.catchFaceInvoke(Module.channelToSerialNo(msg.nChannelID),msg.nChannelID,faceInfo);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                msg = null;
                //System.gc();
                break;
            }
            case NetSDKLib.EVENT_IVS_FACEDETECT:   ///< 人脸检测
            {
                break;
            }
            default:
                break;
        }
        return 0;
    }
}
