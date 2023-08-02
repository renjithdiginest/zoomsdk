import type {ZoomVideoSDKVirtualBackgroundDataType} from "react-native-zoom-video-sdk";

export type ZoomVideoSdkVirtualBackgroundItemType = {
    filePath: string;
    imageName: string;
    type: ZoomVideoSDKVirtualBackgroundDataType;
    canBeDeleted: boolean;
};

export class ZoomVideoSdkVirtualBackgroundItem implements ZoomVideoSdkVirtualBackgroundItemType {
    filePath;
    imageName;
    type;
    canBeDeleted;

    constructor(item: ZoomVideoSdkVirtualBackgroundItemType) {
        this.filePath = item.filePath;
        this.imageName = item.imageName;
        this.type = item.type;
        this.canBeDeleted = item.canBeDeleted;
    }
}