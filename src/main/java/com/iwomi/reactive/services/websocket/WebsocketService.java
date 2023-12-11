package com.iwomi.reactive.services.websocket;

import com.iwomi.reactive.model.MessageModel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketService implements IWebsocketService{

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebsocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void sendToAll(MessageModel model) {
        simpMessagingTemplate.convertAndSend("/all/messages", model);
    }

    @Override
    public MessageModel sendToUser(MessageModel model) {
        return null;
    }
}
