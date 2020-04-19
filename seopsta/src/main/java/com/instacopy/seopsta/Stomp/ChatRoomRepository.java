package com.instacopy.seopsta.Stomp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoomEntitiy, String> {

}
