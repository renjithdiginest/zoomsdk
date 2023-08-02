package com.reactnativezoom.videosdk;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativezoom.videosdk.convert.RNZoomVideoSDKErrors;

import us.zoom.sdk.ZoomVideoSDK;
import us.zoom.sdk.ZoomVideoSDKRemoteCameraControlHelper;
import us.zoom.sdk.ZoomVideoSDKUser;

public class RNZoomVideoSdkRemoteCameraControlHelperModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  RNZoomVideoSdkRemoteCameraControlHelperModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNZoomVideoSdkRemoteCameraControlHelper";
  }

  private ZoomVideoSDKRemoteCameraControlHelper getRemoteCameraControlHelper() {
    ZoomVideoSDKRemoteCameraControlHelper remoteCameraControlHelper = null;
    try {
      ZoomVideoSDKUser mySelf = ZoomVideoSDK.getInstance().getSession().getMySelf();
      remoteCameraControlHelper = mySelf.getRemoteCameraControlHelper();
      if (remoteCameraControlHelper == null) {
        throw new Exception("No Remote Camera Control Helper Found");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return remoteCameraControlHelper;
  }

  @ReactMethod
  public void requestControlRemoteCamera(Promise promise) {
    promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().requestControlRemoteCamera()));
  }

  @ReactMethod
  public void giveUpControlRemoteCamera(Promise promise) {
    promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().giveUpControlRemoteCamera()));
  }

  @ReactMethod
  public void turnLeft(int range, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().turnLeft(range)));
      }
    });
  }

  @ReactMethod
  public void turnRight(int range, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().turnRight(range)));
      }
    });
  }

  @ReactMethod
  public void turnDown(int range, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().turnDown(range)));
      }
    });
  }

  @ReactMethod
  public void turnUp(int range, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().turnUp(range)));
      }
    });
  }

  @ReactMethod
  public void zoomIn(int range, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().zoomIn(range)));
      }
    });
  }

  @ReactMethod
  public void zoomOut(int range, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(RNZoomVideoSDKErrors.valueOf(getRemoteCameraControlHelper().zoomOut(range)));
      }
    });
  }

}
