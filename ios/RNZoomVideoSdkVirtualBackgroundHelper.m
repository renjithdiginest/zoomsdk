#import <React/RCTConvert.h>
#import "RNZoomVideoSdk.h"
#import "RNZoomVideoSdkVirtualBackgroundHelper.h"
#import "RNZoomVideoSdkVirtualBackgroundItem.h"
#import "RCTConvert+RNZoomVideoSdk.h"

@implementation RNZoomVideoSdkVirtualBackgroundHelper

- (ZoomVideoSDKVirtualBackgroundHelper *)getVirtualBackgroundHelper
{
    ZoomVideoSDKVirtualBackgroundHelper* virtualBackgroundHelper = nil;
    @try {
        virtualBackgroundHelper = [[ZoomVideoSDK shareInstance] getVirtualBackgroundHelper];
        if (virtualBackgroundHelper == nil) {
            NSException *e = [NSException exceptionWithName:@"NoVirtualBackgroundHelperFound" reason:@"No Virtual Background Helper" userInfo:nil];
            @throw e;
        }
    } @catch (NSException *e) {
        NSLog(@"%@ - %@", e.name, e.reason);
    }
    return virtualBackgroundHelper;
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(isSupportVirtualBackground:(RCTPromiseResolveBlock)resolve
        withRejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        resolve(@([[self getVirtualBackgroundHelper] isSupportVirtualBackground]));
    });
}

RCT_EXPORT_METHOD(addVirtualBackgroundItem:(NSString *)filePath
        withResolve:(RCTPromiseResolveBlock)resolve
        withRejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSData *data = [NSData dataWithContentsOfFile:filePath];
        UIImage *img = [UIImage imageWithData:data];
        ZoomVideoSDKVirtualBackgroundItem* item = [[self getVirtualBackgroundHelper] addVirtualBackgroundItem:img];
        resolve([RNZoomVideoSdkVirtualBackgroundItem mapVBItem:item]);
    });
}

RCT_EXPORT_METHOD(removeVirtualBackgroundItem:(NSString *)imageName
        withResolve:(RCTPromiseResolveBlock)resolve
        withRejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSArray<ZoomVideoSDKVirtualBackgroundItem * >* itemArray = [[self getVirtualBackgroundHelper] getVirtualBackgroundItemList];
        ZoomVideoSDKError ret = Errors_Wrong_Usage;
        for (ZoomVideoSDKVirtualBackgroundItem* item in itemArray) {
            if ([[item imageName] isEqualToString: imageName]){
                ret = [[self getVirtualBackgroundHelper] removeVirtualBackgroundItem: item];
            }
        }
        resolve([[RCTConvert ZoomVideoSDKErrorValuesReversed] objectForKey: @(ret)]);
    });
}

RCT_EXPORT_METHOD(getVirtualBackgroundItemList:(RCTPromiseResolveBlock)resolve
        withRejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        resolve([RNZoomVideoSdkVirtualBackgroundItem mapItemArray:[[self getVirtualBackgroundHelper] getVirtualBackgroundItemList]]);
    });
}

RCT_EXPORT_METHOD(setVirtualBackgroundItem:(NSString *)imageName
        withResolve:(RCTPromiseResolveBlock)resolve
        withRejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSArray<ZoomVideoSDKVirtualBackgroundItem * >* itemArray = [[self getVirtualBackgroundHelper] getVirtualBackgroundItemList];
        ZoomVideoSDKError ret = Errors_Wrong_Usage;
        for (ZoomVideoSDKVirtualBackgroundItem* item in itemArray) {
            if ([[item imageName] isEqualToString: imageName]){
                ret = [[self getVirtualBackgroundHelper] setVirtualBackgroundItem: item];
            }
        }
        resolve([[RCTConvert ZoomVideoSDKErrorValuesReversed] objectForKey: @(ret)]);
    });
}

@end
