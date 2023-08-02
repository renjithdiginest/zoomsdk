import { useCallback } from 'react';
import { NativeModules, NativeEventEmitter } from 'react-native';

export enum EventType {
  onSessionJoin = 'onSessionJoin',
  onSessionLeave = 'onSessionLeave',
  onUserJoin = 'onUserJoin',
  onUserLeave = 'onUserLeave',
  onUserVideoStatusChanged = 'onUserVideoStatusChanged',
  onUserAudioStatusChanged = 'onUserAudioStatusChanged',
  onUserShareStatusChanged = 'onUserShareStatusChanged',
  onLiveStreamStatusChanged = 'onLiveStreamStatusChanged',
  onChatNewMessageNotify = 'onChatNewMessageNotify',
  onUserNameChanged = 'onUserNameChanged',
  onUserHostChanged = 'onUserHostChanged',
  onUserManagerChanged = 'onUserManagerChanged',
  onUserActiveAudioChanged = 'onUserActiveAudioChanged',
  onSessionNeedPassword = 'onSessionNeedPassword',
  onSessionPasswordWrong = 'onSessionPasswordWrong',
  onError = 'onError',
  onCommandReceived = 'onCommandReceived',
  onCommandChannelConnectResult = 'onCommandChannelConnectResult',
  onCloudRecordingStatus = 'onCloudRecordingStatus',
  onHostAskUnmute = 'onHostAskUnmute',
  onInviteByPhoneStatus = 'onInviteByPhoneStatus',
  onChatDeleteMessageNotify = 'onChatDeleteMessageNotify',
  onLiveTranscriptionStatus = 'onLiveTranscriptionStatus',
  onLiveTranscriptionMsgReceived = 'onLiveTranscriptionMsgReceived',
  onLiveTranscriptionMsgError = 'onLiveTranscriptionMsgError',
  onLiveTranscriptionMsgInfoReceived = 'onLiveTranscriptionMsgInfoReceived',
  onMultiCameraStreamStatusChanged = 'onMultiCameraStreamStatusChanged',
  onRequireSystemPermission = 'onRequireSystemPermission',
  onProxySettingNotification = 'onProxySettingNotification',
  onSSLCertVerifiedFailNotification = 'onSSLCertVerifiedFailNotification',
  onUserVideoNetworkStatusChanged = 'onUserVideoNetworkStatusChanged',
  onCameraControlRequestResult = 'onCameraControlRequestResult',
  onUserRecordingConsent = 'onUserRecordingConsent',
  onCallCRCDeviceStatusChanged = 'onCallCRCDeviceStatusChanged',
}

const eventEmitter = new NativeEventEmitter(NativeModules.RNZoomVideoSdk);

export function useSdkEventListener() {
  const addListener = useCallback(
    (event: EventType, handler: (data?: any) => void) => {
      return eventEmitter.addListener(event, handler);
    },
    []
  );

  return { addListener };
}
