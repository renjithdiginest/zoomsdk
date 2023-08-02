package com.reactnativezoom.videosdk;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativezoom.videosdk.convert.RNZoomVideoSDKErrors;
import com.reactnativezoom.videosdk.convert.RNZoomVideoSDKCRCProtocol;

import us.zoom.sdk.ZoomVideoSDK;
import us.zoom.sdk.ZoomVideoSDKCRCHelper.ZoomVideoSDKCRCProtocol;
import us.zoom.sdk.ZoomVideoSDKCRCHelper;

public class RNZoomVideoSdkCRCHelperModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  RNZoomVideoSdkCRCHelperModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNZoomVideoSdkCRCHelper";
  }

  private ZoomVideoSDKCRCHelper getCRCHelper() {
    ZoomVideoSDKCRCHelper CRCHelper = null;

    try {
      CRCHelper = ZoomVideoSDK.getInstance().getCRCHelper();
      if (CRCHelper == null) {
        throw new Exception("No CRC Helper Found");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return CRCHelper;
  }

  @ReactMethod
  public void isCRCEnabled(Promise promise) {
    promise.resolve(getCRCHelper().isCRCEnabled());
  }

  @ReactMethod
  public void callCRCDevice(String address, String protocol, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ZoomVideoSDKCRCProtocol protocolEnum = RNZoomVideoSDKCRCProtocol.valueOf(protocol);
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getCRCHelper().callCRCDevice(address, protocolEnum)));
      }
    });
  }

  @ReactMethod
  public void cancelCallCRCDevice(Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getCRCHelper().cancelCallCRCDevice()));
      }
    });
  }
}
