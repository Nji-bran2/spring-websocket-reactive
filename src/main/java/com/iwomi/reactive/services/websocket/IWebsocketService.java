package com.iwomi.reactive.services.websocket;

import com.iwomi.reactive.model.MessageModel;
import org.springframework.messaging.handler.annotation.SendTo;

public interface IWebsocketService {
    void sendToAll(final MessageModel model);
    MessageModel sendToUser(final MessageModel model);

}
