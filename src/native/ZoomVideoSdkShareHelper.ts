import { NativeModules } from 'react-native';
import type { Errors } from '../native/ZoomVideoSdk';

const { RNZoomVideoSdkShareHelper } = NativeModules;

export type ZoomVideoSdkShareHelperType = {
  shareScreen: () => void;
  stopShare: () => Promise<Errors>;
  lockShare: (lock: boolean) => Promise<Errors>;
  isOtherSharing: () => Promise<boolean>;
  isScreenSharingOut: () => Promise<boolean>;
  isShareLocked: () => Promise<boolean>;
  isSharingOut: () => Promise<boolean>;
};

export class ZoomVideoSdkShareHelper implements ZoomVideoSdkShareHelperType {

  async shareScreen() {
    return await RNZoomVideoSdkShareHelper.shareScreen();
  }

  async stopShare() {
    return await RNZoomVideoSdkShareHelper.stopShare();
  }

  async lockShare(lock: boolean) {
    return await RNZoomVideoSdkShareHelper.lockShare(lock);
  }

  async isOtherSharing() {
    return await RNZoomVideoSdkShareHelper.isOtherSharing();
  }

  async isScreenSharingOut() {
    return await RNZoomVideoSdkShareHelper.isScreenSharingOut();
  }

  async isShareLocked() {
    return await RNZoomVideoSdkShareHelper.isShareLocked();
  }

  async isSharingOut() {
    return await RNZoomVideoSdkShareHelper.isSharingOut();
  }
}
