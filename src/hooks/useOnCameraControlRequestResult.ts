import { useEffect } from 'react';
import { useZoom } from './useZoom';
import { EventType } from './useSdkEventListener';
import type { ZoomVideoSdkUserType } from '../native/ZoomVideoSdkUser';

export function useOnCameraControlRequestResult(
    callback: (params: { user: ZoomVideoSdkUserType; approved: boolean }) => void
) {
    const zoom = useZoom();
    useEffect(() => {
        const listener = zoom.addListener(EventType.onCameraControlRequestResult, callback);
        return () => listener.remove();
    }, [zoom, callback]);
}