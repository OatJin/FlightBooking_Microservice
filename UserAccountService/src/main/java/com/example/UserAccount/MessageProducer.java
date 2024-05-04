package com.example.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service 
public class MessageProducer {
	
    //private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public void sendMessage(String topicName, String message) {
//    	kafkaTemplate.send(topicName, message) ;
//     
//        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Sent message=[" + message + 
//                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" + 
//                    message + "] due to : " + ex.getMessage());
//            }
//        });
//    }
  public void sendMessage(String topicName, String message) {
	kafkaTemplate.send(topicName, message) ;
  }

}
