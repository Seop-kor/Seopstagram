package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.ChatEntity;
import com.instacopy.seopsta.Entity.MessageEntity;
import com.instacopy.seopsta.Entity.RoomEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ChatMessageDTO {
    private String id;
    public enum MessageType{
        TEXT, IMAGE
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

    public MessageEntity toEntity(){
        ChatEntity chatEntity = ChatEntity.builder().messageType(type).sender(sender).message(message).build();
        RoomEntity roomEntity = RoomEntity.builder().roomId(roomId).chat(chatEntity).build();
        return MessageEntity.builder().id(id).room(roomEntity).build();
    }

    @Builder
    public ChatMessageDTO(String id,MessageType type, String roomId, String sender, String message){
        this.id  = id;
        this.type = type;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
    }
}
