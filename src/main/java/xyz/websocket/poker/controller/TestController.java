package xyz.websocket.poker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestController {
    @Autowired
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/sendTo")
    @SendTo("/topics/sendTo")
    public String SendToMessage() throws Exception {
        System.out.println("ttttt");
        return "SendTo";

    }

    @MessageMapping("/Template")
    public void SendTemplateMessage() {
        webSocket.convertAndSend("/topics/template", "Template");
    }

    @RequestMapping(value = "/api")
    public void SendAPI() {
        webSocket.convertAndSend("/topics/api", "API");
    }
}
