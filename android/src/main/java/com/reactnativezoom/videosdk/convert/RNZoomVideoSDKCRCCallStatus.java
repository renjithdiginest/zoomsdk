package com.reactnativezoom.videosdk.convert;

import com.facebook.react.bridge.NoSuchKeyException;

import java.util.HashMap;
import java.util.Map;

import us.zoom.sdk.ZoomVideoSDKCRCCallStatus;

public class RNZoomVideoSDKCRCCallStatus {

  private static final Map<ZoomVideoSDKCRCCallStatus, String> statusMap =
    new HashMap<ZoomVideoSDKCRCCallStatus, String>() {{
      put(ZoomVideoSDKCRCCallStatus.ZoomVideoSDKCRCCallOutStatus_Success, "ZoomVideoSDKCRCCallOutStatus_Success");
      put(ZoomVideoSDKCRCCallStatus.ZoomVideoSDKCRCCallOutStatus_Ring, "ZoomVideoSDKCRCCallOutStatus_Ring");
      put(ZoomVideoSDKCRCCallStatus.ZoomVideoSDKCRCCallOutStatus_Timeout, "ZoomVideoSDKCRCCallOutStatus_Timeout");
      put(ZoomVideoSDKCRCCallStatus.ZoomVideoSDKCRCCallOutStatus_Busy, "ZoomVideoSDKCRCCallOutStatus_Busy");
      put(ZoomVideoSDKCRCCallStatus.ZoomVideoSDKCRCCallOutStatus_Decline, "ZoomVideoSDKCRCCallOutStatus_Decline");
      put(ZoomVideoSDKCRCCallStatus.ZoomVideoSDKCRCCallOutStatus_Failed, "ZoomVideoSDKCRCCallOutStatus_Failed");
    }};

  public static String valueOf(ZoomVideoSDKCRCCallStatus name) {
    String status;
    try {
      status = (name != null) ? statusMap.get(name) : null;
    } catch (NoSuchKeyException e) {
      status = null;
    }
    return status;
  }
}
