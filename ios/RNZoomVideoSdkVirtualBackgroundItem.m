#import "RNZoomVideoSdkVirtualBackgroundItem.h"
#import "RCTConvert+RNZoomVideoSdk.h"

@implementation RNZoomVideoSdkVirtualBackgroundItem

+ (NSDictionary *)mapVBItem: (ZoomVideoSDKVirtualBackgroundItem *)item {
    @try {
        NSMutableDictionary *mappedVBItem = [[NSMutableDictionary alloc] init];
        if (item == nil) {
            return mappedVBItem;
        }
        NSDictionary *itemData = @{
                @"filePath": [item imageFilePath],
                @"imageName": [item imageName],
                @"type": [[RCTConvert ZoomVideoSDKVirtualBackgroundDataTypeValuesReversed] objectForKey: @([item type])],
                @"canBeDeleted": @([item canVirtualBackgroundBeDeleted]),
        };
        [mappedVBItem setDictionary:itemData];
        return mappedVBItem;
    }
    @catch (NSException *e) {
        return @{};
    }
}

+ (NSMutableArray *)mapItemArray: (NSArray <ZoomVideoSDKVirtualBackgroundItem*> *)itemArray {
    NSMutableArray *mappedItemArray = [NSMutableArray array];
    if (itemArray == nil) {
        return mappedItemArray;
    }
    @try {
        [itemArray enumerateObjectsUsingBlock:^(ZoomVideoSDKVirtualBackgroundItem * _Nonnull item, NSUInteger idx, BOOL * _Nonnull stop) {
            [mappedItemArray addObject: [self mapVBItem: item]];
        }];
    }
    @finally {
        return mappedItemArray;
    }
}

RCT_EXPORT_MODULE()
// TODO: Native methods here

@end
