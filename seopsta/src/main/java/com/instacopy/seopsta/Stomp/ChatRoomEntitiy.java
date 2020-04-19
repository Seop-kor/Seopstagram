package com.instacopy.seopsta.Stomp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Document(collection = "chatroom")
public class ChatRoomEntitiy {
    private String roomId;
    private String name;

    @Builder
    public ChatRoomEntitiy(String roomId, String name){
        this.roomId = roomId;
        this.name = name;
    }
}
