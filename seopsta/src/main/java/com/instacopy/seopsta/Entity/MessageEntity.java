package com.instacopy.seopsta.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Document(collection = "message")
public class MessageEntity {
    @Id
    private String id;
    private String usernick;
    private Object rooms;

    @Builder
    public MessageEntity(String id, String usernick, RoomEntity room){
        this.id = id;
        this.usernick = usernick;
        this.rooms = room;
    }

    public MessageEntity(String id, String usernick, List<RoomEntity> rooms){
        this.id = id;
        this.usernick = usernick;
        this.rooms = rooms;
    }
}
