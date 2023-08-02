import { NativeModules } from 'react-native';
import type { Errors } from '../native/ZoomVideoSdk';

const { RNZoomVideoSdkCmdChannel } = NativeModules;

export type ZoomVideoSdkCmdChannelType = {
  sendCommand: (receiverId: string, strCmd: string) => Promise<Errors>;
};

export class ZoomVideoSdkCmdChannel {

  async sendCommand(receiverId: string, strCmd: string) {
    return await RNZoomVideoSdkCmdChannel.sendCommand(receiverId, strCmd);
  }
}
