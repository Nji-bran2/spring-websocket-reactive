package com.iwomi.reactive.controllers;

import com.iwomi.reactive.model.MessageModel;
import com.iwomi.reactive.services.UserService;
import com.iwomi.reactive.services.websocket.IWebsocketService;
import org.apache.kafka.common.protocol.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebsocketController {
    private final IWebsocketService iWebsocketService;
    private final UserService userService;

    public WebsocketController(IWebsocketService iWebsocketService, UserService userService) {
        this.iWebsocketService = iWebsocketService;
        this.userService = userService;
    }

    // below is actually app/application from websocket config
    @MessageMapping("/application")
    public void send(final MessageModel model) {
        iWebsocketService.sendToAll(model);
    }

    @MessageMapping("/private")
    public void  sendToSpecificUser(@Payload MessageModel model){
        String user = model.to();

        if (userService.userExists(user)) {
            iWebsocketService.sendToUser(model);
        } else {
            System.out.println("User with Name " + user + " does not exist.");
        }

    }
}
