import { NativeModules } from 'react-native';
import type { Errors } from '../native/ZoomVideoSdk';

const { RNZoomVideoSdkRemoteCameraControlHelper } = NativeModules;

export type ZoomVideoSdkRemoteCameraControlHelperType = {
    requestControlRemoteCamera: () => Promise<Errors>;
    giveUpControlRemoteCamera: () => Promise<Errors>;
    turnLeft: (range: number) => Promise<Errors>;
    turnRight: (range: number) => Promise<Errors>;
    turnDown: (range: number) => Promise<Errors>;
    turnUp: (range: number) => Promise<Errors>;
    zoomIn: (range: number) => Promise<Errors>;
    zoomOut: (range: number) => Promise<Errors>;
};

export class ZoomVideoSdkRemoteCameraControlHelper implements ZoomVideoSdkRemoteCameraControlHelperType {

    async requestControlRemoteCamera() {
        return await RNZoomVideoSdkRemoteCameraControlHelper.requestControlRemoteCamera();
    }

    async giveUpControlRemoteCamera() {
        return await RNZoomVideoSdkRemoteCameraControlHelper.giveUpControlRemoteCamera();
    }

    async turnLeft(range: number) {
        return await RNZoomVideoSdkRemoteCameraControlHelper.turnLeft(range);
    }

    async turnRight(range: number) {
        return await RNZoomVideoSdkRemoteCameraControlHelper.turnRight(range);
    }

    async turnDown(range: number) {
        return await RNZoomVideoSdkRemoteCameraControlHelper.turnDown(range);
    }

    async turnUp(range: number) {
        return await RNZoomVideoSdkRemoteCameraControlHelper.turnUp(range);
    }

    async zoomIn(range: number) {
        return await RNZoomVideoSdkRemoteCameraControlHelper.zoomIn(range);
    }

    async zoomOut(range: number) {
        return await RNZoomVideoSdkRemoteCameraControlHelper.zoomOut(range);
    }
}