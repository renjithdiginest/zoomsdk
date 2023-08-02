package com.reactnativezoom.videosdk.convert;

import com.facebook.react.bridge.NoSuchKeyException;

import java.util.HashMap;
import java.util.Map;

import us.zoom.sdk.ZoomVideoSDKVirtualBackgroundDataType;

public class RNZoomVideoSdkVirtualBackgroundDataType {

    private static final Map<ZoomVideoSDKVirtualBackgroundDataType, String> virtualBackgroundDataType =
            new HashMap<ZoomVideoSDKVirtualBackgroundDataType, String>() {{
                put(ZoomVideoSDKVirtualBackgroundDataType.ZoomVideoSDKVirtualBackgroundDataType_Blur, "ZoomVideoSDKVirtualBackgroundDataType_Blur");
                put(ZoomVideoSDKVirtualBackgroundDataType.ZoomVideoSDKVirtualBackgroundDataType_Image, "ZoomVideoSDKVirtualBackgroundDataType_Image");
                put(ZoomVideoSDKVirtualBackgroundDataType.ZoomVideoSDKVirtualBackgroundDataType_None, "ZoomVideoSDKVirtualBackgroundDataType_None");
            }};

    public static String valueOf(ZoomVideoSDKVirtualBackgroundDataType type) {
        String result;
        try {
            result = (type != null) ? virtualBackgroundDataType.get(type) : null;
        } catch (NoSuchKeyException e) {
            result = null;
        }
        return result;
    }

}
