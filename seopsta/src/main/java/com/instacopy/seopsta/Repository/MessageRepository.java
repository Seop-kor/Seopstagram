package com.instacopy.seopsta.Repository;

import com.instacopy.seopsta.Entity.MessageEntity;
import com.instacopy.seopsta.Entity.RoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<MessageEntity,String> {
    public List<MessageEntity> findAllByUsernick(String usernick);
    public MessageEntity findByRooms(RoomEntity rooms);
}
