package com.iwomi.reactive.frameworks.data.listeners;

import com.iwomi.reactive.core.DatabaseEnum;
import com.iwomi.reactive.model.MessageModel;
import com.iwomi.reactive.services.websocket.IWebsocketService;
import com.iwomi.reactive.services.websocket.WebsocketService;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersistEntityListener {

    @Autowired
    private IWebsocketService iWebsocketService;

    // invoked on repository findAll()
    @PostLoad
    public void persistLoad(Object entityInstance) {
        System.out.println("Loaded "+ entityInstance);
        var model = new MessageModel("Loaded oh", DatabaseEnum.LOADED);
        sendWebsocketNotif(model);
    }

    @PrePersist
    public void creating(Object entityInstance) {
        System.out.println("Creating "+ entityInstance);
        var model = new MessageModel("Creating socket", DatabaseEnum.CREATING);
        sendWebsocketNotif(model);
    }

    @PostPersist
    public void Created(Object entityInstance) {
        System.out.println("created "+ entityInstance);
        var model = new MessageModel("Created socket", DatabaseEnum.CREATED);
        sendWebsocketNotif(model);
    }

    @PreUpdate
    public void updating(Object entityInstance) {
        System.out.println("updating "+ entityInstance);
    }

    @PostUpdate
    public void updated(Object entityInstance) {
        System.out.println("updated "+ entityInstance);
    }

    @PreRemove
    public void removing(Object entityInstance) {
        System.out.println("removing "+ entityInstance);
    }

    @PostRemove
    public void removed(Object entityInstance) {
        System.out.println("removed "+ entityInstance);
    }

    private void sendWebsocketNotif(MessageModel model) {
        iWebsocketService.sendToAll(model);
    }
}
