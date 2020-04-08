package com.instacopy.seopsta.Service;

import com.instacopy.seopsta.Entity.MessageEntity;
import com.instacopy.seopsta.Repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    private MessageRepository repository;

    public void follow(MessageEntity messageEntity){
        repository.save(messageEntity);
    }
}
