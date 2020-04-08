package com.instacopy.seopsta.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomEntity {
    private String roomId;
    private Object chat;

    @Builder
    public RoomEntity(String roomId, ChatEntity chat){
        this.roomId = roomId;
        this.chat = chat;
    }
}
