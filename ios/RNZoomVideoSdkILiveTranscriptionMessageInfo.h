#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#import <ZoomVideoSDK.h>

@interface RNZoomVideoSdkILiveTranscriptionMessageInfo : NSObject <RCTBridgeModule>

+ (NSDictionary *)mapMessageInfo: (ZoomVideoSDKLiveTranscriptionMessageInfo*) messageInfo;
+ (NSMutableArray *)mapMessageInfoArray: (NSArray <ZoomVideoSDKLiveTranscriptionMessageInfo*>*) messageInfoArray;

@end
