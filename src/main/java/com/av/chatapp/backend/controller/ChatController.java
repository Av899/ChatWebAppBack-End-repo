package com.av.chatapp.backend.controller;

import java.time.LocalDateTime;

import com.av.chatapp.backend.config.AppConstants;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.av.chatapp.backend.entities.Message;
import com.av.chatapp.backend.entities.Room;
import com.av.chatapp.backend.payload.MessageRequest;
import com.av.chatapp.backend.repositories.RoomRepository;

@Controller
@CrossOrigin(AppConstants.FRONT_END_BASE_URL)
public class ChatController {


    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //for sending and recieving messages
    @MessageMapping("/sendMessage/{roomId}")//client will send to this(/app/sendMessage/{roomId})
    @SendTo("/topic/room/{roomId}")//client will subscribe to this
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) {

        Room room=roomRepository.findByRoomId(request.getRoomId());

        Message message=new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if(room != null) {//if found
            room.getMessages().add(message);
            roomRepository.save(room);
        }else{//if not
            throw new RuntimeException("Room does not exist");
        }
        return message;

    }
}

