import { NativeModules, Platform } from 'react-native';
import { validateNonEmptyStringProp } from '../utils/validation';
import type { Errors } from '../native/ZoomVideoSdk';

const { RNZoomVideoSdkVideoHelper } = NativeModules;

export enum VideoPreferenceMode {
  Balance = 'ZoomVideoSDKVideoPreferenceMode_Balance',
  Sharpness = 'ZoomVideoSDKVideoPreferenceMode_Sharpness',
  Smoothness = 'ZoomVideoSDKVideoPreferenceMode_Smoothness',
  Custom = 'ZoomVideoSDKVideoPreferenceMode_Custom',
}

export type VideoPreferenceSetting = {
  mode?: VideoPreferenceMode;
  maximumFrameRate?: number;
  minimumFrameRate?: number;
};

export type ZoomVideoSdkCameraDeviceType = {
  deviceId: string;
  deviceName: string;
};

export type ZoomVideoSdkVideoHelperType = {
  startVideo: () => Promise<Errors>;
  stopVideo: () => Promise<Errors>;
  switchCamera: (deviceId?: string) => Promise<boolean>;
  rotateMyVideo: (rotation: number) => Promise<boolean>;
  getCameraList: () => Promise<ZoomVideoSdkCameraDeviceType[]>;
  getNumberOfCameras: () => Promise<number>;
  setVideoQualityPreference: (setting: VideoPreferenceSetting) => Promise<Errors>;
  isOriginalAspectRatioEnabled: () => Promise<boolean>;
  enableOriginalAspectRatio: (enable: boolean) => Promise<boolean>;
  isMirrorMyVideoEnabled: () => Promise<boolean>;
  mirrorMyVideo: (enable: boolean) => Promise<Errors>;
};

export class ZoomVideoSdkVideoHelper implements ZoomVideoSdkVideoHelperType {
  async startVideo() {
    return await RNZoomVideoSdkVideoHelper.startVideo();
  }

  async stopVideo() {
    return await RNZoomVideoSdkVideoHelper.stopVideo();
  }

  async switchCamera(deviceId?: string) {
    if (Platform.OS === 'ios') {
      return await RNZoomVideoSdkVideoHelper.switchCamera();
    }
    return await RNZoomVideoSdkVideoHelper.switchCamera(deviceId);
  }

  async rotateMyVideo(rotation: number) {
    return await RNZoomVideoSdkVideoHelper.rotateMyVideo(rotation);
  }

  async getCameraList(): Promise<ZoomVideoSdkCameraDeviceType[]> {
    if (Platform.OS === 'ios') {
      return [];
    }
    return await RNZoomVideoSdkVideoHelper.getCameraList();
  }

  async getNumberOfCameras() {
    if (Platform.OS === 'ios') {
      return;
    }
    return await RNZoomVideoSdkVideoHelper.getNumberOfCameras();
  }

  async setVideoQualityPreference(setting: VideoPreferenceSetting) {
    console.log(setting); // DEBUG
    validateNonEmptyStringProp(
      setting,
      'VideoPreferenceSetting',
      'videoPreferenceMode'
    );
    return await RNZoomVideoSdkVideoHelper.setVideoQualityPreference(setting);
  }

  async isOriginalAspectRatioEnabled() {
    return await RNZoomVideoSdkVideoHelper.isOriginalAspectRatioEnabled();
  }

  async enableOriginalAspectRatio(enable: boolean) {
    return await RNZoomVideoSdkVideoHelper.enableOriginalAspectRatio(enable);
  }

  async isMirrorMyVideoEnabled() {
    return await RNZoomVideoSdkVideoHelper.isMirrorMyVideoEnabled();
  }

  async mirrorMyVideo(enable: boolean) {
    return await RNZoomVideoSdkVideoHelper.mirrorMyVideo(enable);
  }
}
