package by.itsparnter.task.controller;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.service.BulbService;
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

    private final BulbService bulbService;

    public ChatRoomController(SimpMessageSendingOperations messageTemplate, BulbService bulbService) {
        this.messageTemplate = messageTemplate;
        this.bulbService = bulbService;
    }

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, @Payload RoomDto roomDto) {
        logger.info("Room DTO is received " + roomDto.getId() + "-" + roomDto.getName() + "-" + roomDto.getCountryName() + "-" + roomDto.isBulbTurnedOn());
        RoomDto roomDtoSent = bulbService.switchBulbInTheRoom(roomDto);
        messageTemplate.convertAndSend(format("/chat-room/%s", roomId), roomDtoSent);
        logger.info("Room DTO is sent " + roomDtoSent.getId() + "-" + roomDtoSent.getName() + "-" + roomDtoSent.getCountryName() + "-" + roomDtoSent.isBulbTurnedOn());
    }

}
