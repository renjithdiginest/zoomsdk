import { useEffect } from 'react';
import { useZoom } from './useZoom';
import { EventType } from './useSdkEventListener';
import type {ZoomVideoSdkUser} from "../native/ZoomVideoSdkUser";

export function useOnUserRecordingConsent(
    callback: (params: {
        user: ZoomVideoSdkUser
    }) => void
) {
    const zoom = useZoom();
    useEffect(() => {
        const listener = zoom.addListener(
            EventType.onUserRecordingConsent,
            callback
        );
        return () => listener.remove();
    }, [zoom, callback]);
}
