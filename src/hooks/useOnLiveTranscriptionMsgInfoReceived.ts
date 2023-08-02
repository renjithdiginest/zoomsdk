import { useEffect } from 'react';
import { useZoom } from './useZoom';
import { EventType } from './useSdkEventListener';
import type {ZoomVideoSdkLiveTranscriptionMessageInfo} from "../native/ZoomVideoSdkLiveTranscriptionMessageInfo";

export function useOnLiveTranscriptionMsgInfoReceived(
    callback: (params: {
        messageInfo: ZoomVideoSdkLiveTranscriptionMessageInfo;
    }) => void
) {
    const zoom = useZoom();
    useEffect(() => {
        const listener = zoom.addListener(
            EventType.onLiveTranscriptionMsgInfoReceived,
            callback
        );
        return () => listener.remove();
    }, [zoom, callback]);
}