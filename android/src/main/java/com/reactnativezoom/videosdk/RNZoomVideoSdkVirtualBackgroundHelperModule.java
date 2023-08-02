package com.reactnativezoom.videosdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativezoom.videosdk.convert.RNZoomVideoSDKErrors;

import java.util.List;
import java.util.ArrayList;

import us.zoom.sdk.ZoomVideoSDK;
import us.zoom.sdk.ZoomVideoSDKVideoView;
import us.zoom.sdk.ZoomVideoSDKVirtualBackgroundHelper;
import us.zoom.sdk.ZoomVideoSDKVirtualBackgroundItem;

public class RNZoomVideoSdkVirtualBackgroundHelperModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private ZoomVideoSDKVideoView videoView;

  RNZoomVideoSdkVirtualBackgroundHelperModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNZoomVideoSdkVirtualBackgroundHelper";
  }

  private ZoomVideoSDKVirtualBackgroundHelper getVirtualBackgroundHelper() {
    ZoomVideoSDKVirtualBackgroundHelper virtualBackgroundHelper = null;
    try {
      virtualBackgroundHelper = ZoomVideoSDK.getInstance().getVirtualBackgroundHelper();
      if (virtualBackgroundHelper == null) {
        throw new Exception("No Virtual Background Helper Found");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return virtualBackgroundHelper;
  }

  @ReactMethod
  public void isSupportVirtualBackground(Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        promise.resolve(getVirtualBackgroundHelper().isSupportVirtualBackground());
      }
    });
  }

  @ReactMethod
  public void addVirtualBackgroundItem(String filePath, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        ZoomVideoSDKVirtualBackgroundItem item = getVirtualBackgroundHelper().addVirtualBackgroundItem(bitmap);
        promise.resolve(RNZoomVideoSdkVirtualBackgroundItemModule.mapVBItem(item));
      }
    });
  }

  @ReactMethod
  public void removeVirtualBackgroundItem(String imageName, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        int ret = 1;
        List<ZoomVideoSDKVirtualBackgroundItem> itemList = getVirtualBackgroundHelper().getVirtualBackgroundItemList();
        for (ZoomVideoSDKVirtualBackgroundItem item : itemList) {
          if(item.getImageName().equals(imageName)) {
            ret = getVirtualBackgroundHelper().removeVirtualBackgroundItem(item);
          }
        }
        promise.resolve(RNZoomVideoSDKErrors.valueOf(ret));
      }
    });
  }

  @ReactMethod
  public void getVirtualBackgroundItemList(Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        List<ZoomVideoSDKVirtualBackgroundItem> itemList = getVirtualBackgroundHelper().getVirtualBackgroundItemList();
        if (itemList == null) {
          itemList = new ArrayList<>();
        }
        promise.resolve(RNZoomVideoSdkVirtualBackgroundItemModule.mapItemArray(itemList));
      }
    });
  }

  @ReactMethod
  public void setVirtualBackgroundItem(String imageName, Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        int ret = 1;
        List<ZoomVideoSDKVirtualBackgroundItem> itemList = getVirtualBackgroundHelper().getVirtualBackgroundItemList();
        for (ZoomVideoSDKVirtualBackgroundItem item : itemList) {
          if(item.getImageName().equals(imageName)) {
            ret = getVirtualBackgroundHelper().setVirtualBackgroundItem(item);
          }
        }
        promise.resolve(RNZoomVideoSDKErrors.valueOf(ret));
      }
    });
  }

  @ReactMethod
  public void getSelectedVirtualBackgroundItem(Promise promise) {
    reactContext.getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ZoomVideoSDKVirtualBackgroundItem item = getVirtualBackgroundHelper().getSelectedVirtualBackgroundItem();
        promise.resolve(RNZoomVideoSdkVirtualBackgroundItemModule.mapVBItem(item));
      }
    });
  }
}
