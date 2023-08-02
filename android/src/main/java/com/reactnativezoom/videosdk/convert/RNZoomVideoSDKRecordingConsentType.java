package com.reactnativezoom.videosdk.convert;

import com.facebook.react.bridge.NoSuchKeyException;

import java.util.HashMap;
import java.util.Map;

import us.zoom.sdk.ZoomVideoSDKRecordingConsentHandler;

public class RNZoomVideoSDKRecordingConsentType {

    private static final Map<ZoomVideoSDKRecordingConsentHandler.ConsentType, String> consentTypeMap =
        new HashMap<ZoomVideoSDKRecordingConsentHandler.ConsentType, String>() {{
            put(ZoomVideoSDKRecordingConsentHandler.ConsentType.ConsentType_Invalid, "ConsentType_Invalid");
            put(ZoomVideoSDKRecordingConsentHandler.ConsentType.ConsentType_Traditional, "ConsentType_Traditional");
            put(ZoomVideoSDKRecordingConsentHandler.ConsentType.ConsentType_Individual, "ConsentType_Individual");
    }};

    public static String valueOf(ZoomVideoSDKRecordingConsentHandler.ConsentType type) {
        String consentType;
        try {
          consentType = (type != null) ? consentTypeMap.get(type) : null;
        } catch (NoSuchKeyException e) {
          consentType = null;
        }
        return consentType;
      }
}
