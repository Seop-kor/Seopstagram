package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.MessageEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
public class MessageDTO {
    private String id;
    private String usernick;

    public MessageEntity toEntity(){
        return MessageEntity.builder().id(id).usernick(usernick).build();
    }

    @Builder
    public MessageDTO(String id, String usernick){
        this.id = id;
        this.usernick = usernick;
    }
}
