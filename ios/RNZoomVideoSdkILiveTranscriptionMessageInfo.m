#import "RNZoomVideoSdkILiveTranscriptionMessageInfo.h"
#import "RCTConvert+RNZoomVideoSdk.h"

@implementation RNZoomVideoSdkILiveTranscriptionMessageInfo

+ (NSDictionary *)mapMessageInfo: (ZoomVideoSDKLiveTranscriptionMessageInfo*) messageInfo {
    @try {
        NSMutableDictionary *mappedMessageInfo = [[NSMutableDictionary alloc] init];
        NSDictionary *messageInfoData = @{
                @"messageID": [messageInfo messageID],
                @"messageContent": [messageInfo messageContent],
                @"messageType": [[RCTConvert ZoomVideoSDKLiveTranscriptionOperationTypeValuesReversed] objectForKey: @([messageInfo messageType])],
                @"speakerID": [messageInfo speakerID],
                @"speakerName": [messageInfo speakerName],
                @"timeStamp": @([messageInfo timeStamp]),
        };
        [mappedMessageInfo setDictionary:messageInfoData];
        return mappedMessageInfo;
    }
    @catch (NSException *e) {
        return @{};
    }
}

+ (NSMutableArray *)mapMessageInfoArray: (NSArray <ZoomVideoSDKLiveTranscriptionMessageInfo*> *) messageInfoArray {
    NSMutableArray *mappedMessageInfoArray = [NSMutableArray array];

    @try {
        [messageInfoArray enumerateObjectsUsingBlock:^(ZoomVideoSDKLiveTranscriptionMessageInfo * _Nonnull messageInfo, NSUInteger idx, BOOL * _Nonnull stop) {
            [mappedMessageInfoArray addObject: [RNZoomVideoSdkILiveTranscriptionMessageInfo mapMessageInfo: messageInfo]];
        }];
    }
    @finally {
        return mappedMessageInfoArray;
    }
}

RCT_EXPORT_MODULE()
// TODO: Native methods here

@end
