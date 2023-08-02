#import "RNZoomVideoSdkCRCHelper.h"
#import "RNZoomVideoSdkUser.h"
#import "RCTConvert+RNZoomVideoSdk.h"

@implementation RNZoomVideoSdkCRCHelper

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(isCRCEnabled: (RCTPromiseResolveBlock)resolve
                  withRejecter: (RCTPromiseRejectBlock)reject) {

    ZoomVideoSDKCRCHelper* CRCHelper = [[ZoomVideoSDK shareInstance] getCRCHelper];
    resolve(@([CRCHelper isCRCEnabled]));
}

RCT_EXPORT_METHOD(callCRCDevice: (NSString *)ipAddr
                  protocol: (NSString *)protocol
                  withResolve: (RCTPromiseResolveBlock)resolve
                  withRejecter: (RCTPromiseRejectBlock)reject) {

  dispatch_async(dispatch_get_main_queue(), ^{
    ZoomVideoSDKCRCHelper* CRCHelper = [[ZoomVideoSDK shareInstance] getCRCHelper];
    ZoomVideoSDKCRCProtocol protocolEnum = [RCTConvert ZoomVideoSDKCRCProtocol: protocol];
    ZoomVideoSDKError ret = [CRCHelper callCRCDevice: ipAddr protocol: protocolEnum];
    resolve([[RCTConvert ZoomVideoSDKErrorValuesReversed] objectForKey: @(ret)]);
  });
}

RCT_EXPORT_METHOD(cancelCallCRCDevice: (RCTPromiseResolveBlock)resolve
                  withRejecter: (RCTPromiseRejectBlock)reject) {

  ZoomVideoSDKCRCHelper* CRCHelper = [[ZoomVideoSDK shareInstance] getCRCHelper];
  dispatch_async(dispatch_get_main_queue(), ^{
    resolve([[RCTConvert ZoomVideoSDKErrorValuesReversed] objectForKey: @([CRCHelper cancelCallCRCDevice])]);
  });
}
@end
