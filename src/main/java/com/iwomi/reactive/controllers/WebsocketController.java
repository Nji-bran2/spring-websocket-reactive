package com.iwomi.reactive.controllers;

import com.iwomi.reactive.model.MessageModel;
import com.iwomi.reactive.services.websocket.IWebsocketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsocketController {
    private final IWebsocketService iWebsocketService;

    public WebsocketController(IWebsocketService iWebsocketService) {
        this.iWebsocketService = iWebsocketService;
    }

    // below is actually app/application from websocket config
    @MessageMapping("/application")
    public void send(final MessageModel model) {
        iWebsocketService.sendToAll(model);
    }
}
