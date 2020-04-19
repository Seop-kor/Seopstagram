package com.instacopy.seopsta.Stomp;


import lombok.Data;

import java.util.UUID;


@Data
public class ChatRoom {
    private String roomId;
    private String name;

    public ChatRoomEntitiy toEntity(){
        return ChatRoomEntitiy.builder().roomId(roomId).name(name).build();
    }

    public ChatRoom(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
    }
}
