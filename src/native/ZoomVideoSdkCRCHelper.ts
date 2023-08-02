import { NativeModules } from 'react-native';
import type { Errors, ZoomVideoSdkCRCProtocolType } from '../native/ZoomVideoSdk';

const { RNZoomVideoSdkCRCHelper } = NativeModules;

export type ZoomVideoSdkCRCHelperType = {
  isCRCEnabled: () => Promise<boolean>;
  callCRCDevice: (address: string, protocol: string) => Promise<Errors>;
  cancelCallCRCDevice: () => Promise<Errors>;
};

export class ZoomVideoSdkCRCHelper {

  async isCRCEnabled() {
    return await RNZoomVideoSdkCRCHelper.isCRCEnabled();
  }

  async callCRCDevice(address: string, protocol: ZoomVideoSdkCRCProtocolType) {
    return await RNZoomVideoSdkCRCHelper.callCRCDevice(address, protocol.toString());
  }

  async cancelCallCRCDevice() {
    return await RNZoomVideoSdkCRCHelper.cancelCallCRCDevice();
  }
}

export enum ZoomVideoSDKCRCCallStatus {
  ZoomVideoSDKCRCCallOutStatus_Success = 'ZoomVideoSDKCRCCallOutStatus_Success',
  ZoomVideoSDKCRCCallOutStatus_Ring = 'ZoomVideoSDKCRCCallOutStatus_Ring',
  ZoomVideoSDKCRCCallOutStatus_Timeout = 'ZoomVideoSDKCRCCallOutStatus_Timeout',
  ZoomVideoSDKCRCCallOutStatus_Busy = 'ZoomVideoSDKCRCCallOutStatus_Busy',
  ZoomVideoSDKCRCCallOutStatus_Decline = 'ZoomVideoSDKCRCCallOutStatus_Decline',
  ZoomVideoSDKCRCCallOutStatus_Failed = 'ZoomVideoSDKCRCCallOutStatus_Failed',
}
