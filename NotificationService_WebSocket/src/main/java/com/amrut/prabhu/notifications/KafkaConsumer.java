package com.amrut.prabhu.notifications;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private SimpMessagingTemplate template;

    @KafkaListener(topics = "notification", groupId = "booking-group")
    public void listen(String message) {
        System.out.println("Received message in group group-id: " + message);
        // Sending to WebSocket
        template.convertAndSend("/topic/notifications", "Notification: " + message);
    }
}

