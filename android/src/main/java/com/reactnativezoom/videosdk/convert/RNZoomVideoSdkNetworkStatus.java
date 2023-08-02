package com.reactnativezoom.videosdk.convert;

import com.facebook.react.bridge.NoSuchKeyException;

import java.util.HashMap;
import java.util.Map;

import us.zoom.sdk.ZoomVideoSDKNetworkStatus;

public class RNZoomVideoSdkNetworkStatus {

  private static final Map<ZoomVideoSDKNetworkStatus, String> networkStatus =
    new HashMap<ZoomVideoSDKNetworkStatus, String>() {{
      put(ZoomVideoSDKNetworkStatus.ZoomVideoSDKNetwork_Good, "ZoomVideoSDKNetwork_Good");
      put(ZoomVideoSDKNetworkStatus.ZoomVideoSDKNetwork_Normal, "ZoomVideoSDKNetwork_Normal");
      put(ZoomVideoSDKNetworkStatus.ZoomVideoSDKNetwork_Bad, "ZoomVideoSDKNetwork_Bad");
      put(ZoomVideoSDKNetworkStatus.ZoomVideoSDKNetwork_None, "ZoomVideoSDKNetwork_None");
    }};

  public static String valueOf(ZoomVideoSDKNetworkStatus name) {
    String status;
    try {
      status = (name != null) ? networkStatus.get(name) : null;
    } catch (NoSuchKeyException e) {
      status = null;
    }
    return status;
  }
}
