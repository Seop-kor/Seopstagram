package com.instacopy.seopsta.Entity;

import com.instacopy.seopsta.DTO.ChatMessageDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatEntity {
    private String sender;
    private ChatMessageDTO.MessageType messageType;
    private String message;

    @Builder
    public ChatEntity(String sender, String message, ChatMessageDTO.MessageType messageType){
        this.sender = sender;
        this.messageType = messageType;
        this.message = message;
    }
}
