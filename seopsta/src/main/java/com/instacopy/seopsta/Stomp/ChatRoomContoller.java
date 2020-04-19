package com.instacopy.seopsta.Stomp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatRoomContoller {
    private final ChatService service;

    @GetMapping("/chat/room")
    public String rooms(Model model){
        return "/chat/room";
    }

    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<ChatRoomEntitiy> room(){
        return service.findAllRoom();
    }

    @PostMapping("/chat/room")
    @ResponseBody
    public ChatRoomEntitiy createRoom(ChatRoom chatRoom){
        return service.createChatRoom(chatRoom);
    }

    @GetMapping("/chat/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId){
        model.addAttribute("roomId",roomId);
        return "/chat/roomdetail";
    }

    @GetMapping("/chat/room/{roomId}")
    @ResponseBody
    public ChatRoomEntitiy roomInfo(@PathVariable String roomId){
        return service.findRoomById(roomId);
    }
}
