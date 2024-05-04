package com.example.Promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class PromotionController {

@Autowired
	PromotionService service;
@Autowired
	MessageProducer messageProducer;
@Autowired
	PromotionRepository repo;

	@KafkaListener(topics ="promotion", groupId="booking-group")
	public void checkCode(String code) {
	if(service.checkCode(code)) {
		messageProducer.sendMessage("promotion-return", "correct");
		service.setStatus(code, "Used");
		
	}else {messageProducer.sendMessage("promotion-return", "wrong");

	}
}
}
