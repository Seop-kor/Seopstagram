package com.instacopy.seopsta.Stomp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ChatService {
    private ChatRoomRepository repository;

    public List<ChatRoomEntitiy> findAllRoom(){
        return repository.findAll();
    }

    public ChatRoomEntitiy findRoomById(String id){
        return repository.findById(id).get();
    }

    public ChatRoomEntitiy createChatRoom(ChatRoom chatRoom){
        return repository.save(chatRoom.toEntity());
    }
}
