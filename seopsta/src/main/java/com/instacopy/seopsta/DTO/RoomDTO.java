package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.MessageEntity;
import com.instacopy.seopsta.Entity.RoomEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RoomDTO {
    private String id;
    private String roomId;

    public MessageEntity toEntity(){
        RoomEntity roomEntity = RoomEntity.builder().roomId(roomId).build();
        return MessageEntity.builder().id(id).room(roomEntity).build();
    }

    public RoomEntity toRoomEntity(){
        return RoomEntity.builder().roomId(roomId).build();
    }

    @Builder
    public RoomDTO(String id,String roomId){
        this.id = id;
        this.roomId = roomId;
    }
}
