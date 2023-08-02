import { NativeModules } from 'react-native';
import type { Errors } from '../native/ZoomVideoSdk';
import {ZoomVideoSdkVirtualBackgroundItem} from "./ZoomVideoSdkVirtualBackgroundItem";

const { RNZoomVideoSdkVirtualBackgroundHelper } = NativeModules;

export type ZoomVideoSdkVirtualBackgroundHelperType = {
    isSupportVirtualBackground: () => Promise<boolean>;
    addVirtualBackgroundItem: (filePath: string) => Promise<ZoomVideoSdkVirtualBackgroundItem>;
    removeVirtualBackgroundItem: (imageName: string) => Promise<Errors>;
    getVirtualBackgroundItemList: () => Promise<ZoomVideoSdkVirtualBackgroundItem[]>;
    setVirtualBackgroundItem: (imageName: string) => Promise<Errors>;
};

export class ZoomVideoSdkVirtualBackgroundHelper
    implements ZoomVideoSdkVirtualBackgroundHelperType
{
    async isSupportVirtualBackground() {
        return await RNZoomVideoSdkVirtualBackgroundHelper.isSupportVirtualBackground();
    }

    async addVirtualBackgroundItem(filePath: string) {
        return await RNZoomVideoSdkVirtualBackgroundHelper.addVirtualBackgroundItem(filePath);
    }

    async removeVirtualBackgroundItem(imageName: string) {
        return await RNZoomVideoSdkVirtualBackgroundHelper.removeVirtualBackgroundItem(imageName);
    }

    async getVirtualBackgroundItemList() {
        const items = await RNZoomVideoSdkVirtualBackgroundHelper.getVirtualBackgroundItemList();

        return items.map((item: ZoomVideoSdkVirtualBackgroundItem) => new ZoomVideoSdkVirtualBackgroundItem(item));
    }

    async setVirtualBackgroundItem(imageName: string) {
        return await RNZoomVideoSdkVirtualBackgroundHelper.setVirtualBackgroundItem(imageName);
    }

}