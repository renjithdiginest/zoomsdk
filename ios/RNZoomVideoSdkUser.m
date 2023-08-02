#import "RNZoomVideoSdkUser.h"
#import "RCTConvert+RNZoomVideoSdk.h"

@implementation RNZoomVideoSdkUser

+ (NSDictionary *)mapUser: (ZoomVideoSDKUser*) user {
    @try {
        return @{
            @"userId": [@([user getUserID]) stringValue],
            @"customUserId": [user getCustomUserId],
            @"userName": [user getUserName],
            @"isHost": @([user isHost]),
            @"isManager": @([user isManager]),
        };
    }
    @catch (NSException *e) {
        return @{};
    }
}

+ (NSMutableArray *)mapUserArray: (NSArray<ZoomVideoSDKUser *> *)userArray {
    NSMutableArray *mappedUserArray = [NSMutableArray array];

    @try {
        [userArray enumerateObjectsUsingBlock:^(ZoomVideoSDKUser * _Nonnull user, NSUInteger idx, BOOL * _Nonnull stop) {
            [mappedUserArray addObject: [RNZoomVideoSdkUser mapUser: user]];
        }];
    }
    @finally {
        return mappedUserArray;
    }
}

+ (ZoomVideoSDKUser *)getUser:(NSString*)userId {
    // Check if the user is ourself?
    ZoomVideoSDKUser* myUser = [[[ZoomVideoSDK shareInstance] getSession] getMySelf];

    if ([myUser getUserID] == [userId intValue]) {
        return myUser;
    }

    // Wasn't us, try remote users
    NSArray<ZoomVideoSDKUser *>* remoteUsers = [[[ZoomVideoSDK shareInstance] getSession] getRemoteUsers];
    for (ZoomVideoSDKUser* user in remoteUsers) {
        if ([user getUserID] == [userId intValue]) {
            return user;
        }
    }

    return nil;
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(getUserName:(NSString *)userId
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve([user getUserName]);
    }
}

RCT_EXPORT_METHOD(getShareStatus:(NSString *)userId
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve([[RCTConvert ZoomVideoSDKReceiveSharingStatusValuesReversed] objectForKey: @([[[user getShareCanvas] shareStatus] sharingStatus])]);
    }
}

RCT_EXPORT_METHOD(isHost:(NSString *)userId
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve(@([user isHost]));
    }
}
RCT_EXPORT_METHOD(isManager:(NSString *)userId
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve(@([user isManager]));
    }
}

RCT_EXPORT_METHOD(getMultiCameraCanvasList:(NSString *)userId
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve([user getMultiCameraCanvasList]);
    }
}

RCT_EXPORT_METHOD(getUserVolume:(NSString *)userId
                  withIsSharingAudio: (BOOL) isSharingAudio
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        float volume;
        [user getUserVolume:&volume isShareAudio:isSharingAudio];
        resolve(@(volume));
    }
}

RCT_EXPORT_METHOD(setUserVolume:(NSString *)userId
                  withVolume: (float) volume
                  isShareAudio: (BOOL) isSharingAudio
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve(@([user setUserVolume: volume isShareAudio:isSharingAudio]));
    }
}

RCT_EXPORT_METHOD(canSetUserVolume:(NSString *)userId
                  isShareAudio: (BOOL) isSharingAudio
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve(@([user canSetUserVolume: isSharingAudio]));
    }
}

RCT_EXPORT_METHOD(hasIndividualRecordingConsent:(NSString *)userId
                  withResolve:(RCTPromiseResolveBlock)resolve
                  withRejecter:(RCTPromiseRejectBlock)reject)
{
    ZoomVideoSDKUser *user = [RNZoomVideoSdkUser getUser:userId];
    if (user != nil) {
        resolve(@([user isIndividualRecordAgreed]));
    }
}

@end
