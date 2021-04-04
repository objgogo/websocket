package xyz.websocket.poker.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import xyz.websocket.poker.chat.ChatMessage;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        //채팅 방 처음 들어올 경우
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 입장하였습니다.");
        }else if(ChatMessage.MessageType.LINK.equals(message.getType())){
            //채팅 내용이 LINK일 경우

        }
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);

    }

//    @MessageMapping("/sendTo")
//    @SendTo("/topics/sendTo")
//    public String SendToMessage() throws Exception {
//        return "SendTo";
//    }
}

