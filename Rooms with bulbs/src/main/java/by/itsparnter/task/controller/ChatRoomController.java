package by.itsparnter.task.controller;

import by.itsparnter.task.dto.RoomDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import static java.lang.String.format;

@Controller
public class ChatRoomController {

    private static final Logger logger = LoggerFactory.getLogger(ChatRoomController.class);

    private final SimpMessageSendingOperations messageTemplate;

    @Autowired
    public ChatRoomController(SimpMessageSendingOperations messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, @Payload RoomDto roomDto){
        logger.info(roomId + "room DTO is received " + roomDto.getId());
        boolean currentRoomDtoBulbState = roomDto.isBulbTurnedOn();
        roomDto.setBulbTurnedOn(!currentRoomDtoBulbState);
        messageTemplate.convertAndSend(format("/chat-room/%s",roomId), roomDto);
    }

}
