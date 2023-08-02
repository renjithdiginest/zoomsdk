package com.reactnativezoom.videosdk;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.reactnativezoom.videosdk.convert.RNZoomVideoSdkLiveTranscriptionOperationType;

import java.util.List;

import us.zoom.sdk.ZoomVideoSDKLiveTranscriptionHelper;

public class RNZoomVideoSdkILiveTranscriptionMessageInfoModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  RNZoomVideoSdkILiveTranscriptionMessageInfoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }
  @NonNull
  @Override
  public String getName() {
    return "RNZoomVideoSdkILiveTranscriptionMessageInfo";
  }

  public static ReadableArray mapMessageInfoArray(List<ZoomVideoSDKLiveTranscriptionHelper.ILiveTranscriptionMessageInfo> messageInfoList) {
    WritableArray mapMessageInfoArray = new WritableNativeArray();
    for (ZoomVideoSDKLiveTranscriptionHelper.ILiveTranscriptionMessageInfo messageInfo : messageInfoList) {
      mapMessageInfoArray.pushMap(mapMessageInfo(messageInfo));
    }
    return mapMessageInfoArray;
  }

  public static ReadableMap mapMessageInfo(ZoomVideoSDKLiveTranscriptionHelper.ILiveTranscriptionMessageInfo messageInfo) {
    WritableMap mappedMessageInfo = Arguments.createMap();
    mappedMessageInfo.putString("messageID", messageInfo.getMessageID());
    mappedMessageInfo.putString("messageContent", messageInfo.getMessageContent());
    mappedMessageInfo.putString("messageType", RNZoomVideoSdkLiveTranscriptionOperationType.valueOf(messageInfo.getMessageType()));
    mappedMessageInfo.putString("speakerName", messageInfo.getSpeakerName());
    mappedMessageInfo.putString("speakerID", messageInfo.getSpeakerID());
    mappedMessageInfo.putString("timeStamp", String.valueOf(messageInfo.getTimeStamp()));
    return mappedMessageInfo;
  }
}
