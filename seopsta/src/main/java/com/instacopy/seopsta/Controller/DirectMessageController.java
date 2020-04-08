package com.instacopy.seopsta.Controller;

import com.instacopy.seopsta.DTO.MessageDTO;
import com.instacopy.seopsta.DTO.RoomDTO;
import com.instacopy.seopsta.Entity.MessageEntity;
import com.instacopy.seopsta.Service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class DirectMessageController {
    private MessageService service;

//    @GetMapping("/follow")
//    public void follow(@RequestParam(name = "usernick")String usernick, HttpServletRequest req) throws Exception{
//        RoomDTO roomDTO = RoomDTO.builder().roomId(req.getSession().getAttribute("usernick") + usernick).build();
//        MessageEntity messageEntity = MessageEntity.builder().usernick(req.getSession().getAttribute("usernick").toString()).room(roomDTO.toRoomEntity()).build();
//        service.follow(messageEntity);
//    }

    @GetMapping("/chat/room/enter")
    public String roomDetail(@RequestParam(name = "roomId")String roomId){
        return null; //여기서 이제 대화내용들 조회해서 집어넣어야지..
    }
}
