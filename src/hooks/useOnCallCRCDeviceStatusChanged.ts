import { useEffect } from 'react';
import { useZoom } from './useZoom';
import { EventType } from './useSdkEventListener';
import type { ZoomVideoSDKCRCCallStatus } from '../native/ZoomVideoSdkCRCHelper';

export function useOnCallCRCDeviceStatusChanged(
    callback: (params: { status: ZoomVideoSDKCRCCallStatus }) => void
) {
    const zoom = useZoom();
    useEffect(() => {
        const listener = zoom.addListener(EventType.onCallCRCDeviceStatusChanged, callback);
        return () => listener.remove();
    }, [zoom, callback]);
}
