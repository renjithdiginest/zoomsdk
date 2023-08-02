package com.reactnativezoom.videosdk.convert;

import com.facebook.react.bridge.NoSuchKeyException;

import java.util.HashMap;
import java.util.Map;

import us.zoom.sdk.ZoomVideoSDKCRCHelper.ZoomVideoSDKCRCProtocol;

public class RNZoomVideoSDKCRCProtocol {

  private static final Map<String, ZoomVideoSDKCRCProtocol> protocolMap =
    new HashMap<String, ZoomVideoSDKCRCProtocol>() {{
      put("ZoomVideoSDKCRCProtocol_H323", ZoomVideoSDKCRCProtocol.ZoomVideoSDKCRCProtocol_H323);
      put("ZoomVideoSDKCRCProtocol_SIP", ZoomVideoSDKCRCProtocol.ZoomVideoSDKCRCProtocol_SIP);
    }};

  public static ZoomVideoSDKCRCProtocol valueOf(String name) {
    ZoomVideoSDKCRCProtocol protocol;
    try {
      protocol = (name != null) ? protocolMap.get(name) : null;
    } catch (NoSuchKeyException e) {
      protocol = null;
    }
    return protocol;
  }
}
