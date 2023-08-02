package com.reactnativezoom.videosdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.reactnativezoom.videosdk.convert.RNZoomVideoSdkVirtualBackgroundDataType;

import java.util.List;

import us.zoom.sdk.ZoomVideoSDKVirtualBackgroundItem;

public class RNZoomVideoSdkVirtualBackgroundItemModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  RNZoomVideoSdkVirtualBackgroundItemModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNZoomVideoSdkVirtualBackgroundItem";
  }


  public static ReadableArray mapItemArray(List<ZoomVideoSDKVirtualBackgroundItem> itemList) {
    WritableArray mapItemArray = new WritableNativeArray();
    if (itemList == null) {
      return mapItemArray;
    }
    for (ZoomVideoSDKVirtualBackgroundItem item : itemList) {
      mapItemArray.pushMap(mapVBItem(item));
    }
    return mapItemArray;
  }

  public static ReadableMap mapVBItem(ZoomVideoSDKVirtualBackgroundItem item) {
    WritableMap mappedItem = Arguments.createMap();
    if (item == null) {
      return mappedItem;
    }
    mappedItem.putString("filePath", item.getImageFilePath());
    mappedItem.putString("imageName", item.getImageName());
    mappedItem.putString("type", RNZoomVideoSdkVirtualBackgroundDataType.valueOf(item.getType()));
    mappedItem.putBoolean("canBeDeleted", item.canVirtualBackgroundBeDeleted());
    return mappedItem;
  }

}
