package com.example.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class UserAccountController {
	
	@Autowired
	MessageProducer messageProducer;
	@Autowired
	UserService service;
	
	@KafkaListener(topics = "authen", groupId = "booking-group")
	public void checkLogin(String name) {
		if(service.matchUsername(name)){
			messageProducer.sendMessage("authen-return","correct");

		}
	}
}
