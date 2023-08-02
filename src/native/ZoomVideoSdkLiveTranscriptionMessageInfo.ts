import type {LiveTranscriptionOperationType} from "react-native-zoom-video-sdk";

export type ZoomVideoSdkLiveTranscriptionMessageInfoType = {
    messageID: string;
    messageContent: string;
    messageType: LiveTranscriptionOperationType;
    speakerName: string;
    speakerID: string;
    timeStamp: string;
};

export class ZoomVideoSdkLiveTranscriptionMessageInfo implements ZoomVideoSdkLiveTranscriptionMessageInfoType
{
    messageID;
    messageContent;
    messageType;
    speakerName;
    speakerID;
    timeStamp;

    constructor(messageInfo: ZoomVideoSdkLiveTranscriptionMessageInfoType) {
        this.messageID = messageInfo.messageID;
        this.messageContent = messageInfo.messageContent;
        this.messageType = messageInfo.messageType;
        this.speakerName = messageInfo.speakerName;
        this.speakerID = messageInfo.speakerID;
        this.timeStamp = messageInfo.timeStamp;
    }
}