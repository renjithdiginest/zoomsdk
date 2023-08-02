import { useEffect } from 'react';
import { useZoom } from './useZoom';
import { EventType } from './useSdkEventListener';
import type { NetworkStatus } from '../native/ZoomVideoSdk';
import type {ZoomVideoSdkUser} from "../native/ZoomVideoSdkUser";

export function useOnUserVideoNetworkStatusChanged(
    callback: (params: {
        user: ZoomVideoSdkUser
        status: NetworkStatus;
    }) => void
) {
    const zoom = useZoom();
    useEffect(() => {
        const listener = zoom.addListener(
            EventType.onUserVideoNetworkStatusChanged,
            callback
        );
        return () => listener.remove();
    }, [zoom, callback]);
}