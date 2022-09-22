package com.example.websocket.controller;

import com.example.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public Message say(Message message , Principal principal ) throws InterruptedException {
//        System.out.println("Form client: "+ message.getContent());
//        Thread.sleep(2000);
//        return new Message("Ha Noi" + message.getContent()) ;
        return new Message( principal.getName() + " : " + message.getContent() );
    }
}
