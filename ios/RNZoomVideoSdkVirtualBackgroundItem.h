#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#import <ZoomVideoSDK.h>

@interface RNZoomVideoSdkVirtualBackgroundItem : NSObject <RCTBridgeModule>

+ (NSDictionary *)mapVBItem: (ZoomVideoSDKVirtualBackgroundItem *)item;
+ (NSMutableArray *)mapItemArray: (NSArray <ZoomVideoSDKVirtualBackgroundItem*> *)itemArray;

@end
