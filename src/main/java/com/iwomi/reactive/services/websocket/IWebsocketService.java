package com.iwomi.reactive.services.websocket;

import com.iwomi.reactive.model.MessageModel;
import org.springframework.messaging.handler.annotation.SendTo;

public interface IWebsocketService {
    void sendToAll(final MessageModel model);
    void sendToUser(final MessageModel model);

}
