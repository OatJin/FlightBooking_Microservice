package com.Booking.ms.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BookingController {

@Autowired
private MessageProducer messageProducer;

boolean authen_pass = false;
boolean paid = false;
boolean use_promotion = true;
boolean discount = false;

@KafkaListener(topics = "authen-return", groupId = "booking-group")
public void checkLogin(String user) {
	if(user.equalsIgnoreCase("correct")) {
		authen_pass=true;
	}
}
/*@KafkaListener(topics = "payment-return", groupId = "booking-group")
public void checkPayment(String user) {
	if(user.equalsIgnoreCase(message ของ service payment)) {
		paid=true;
	}
 * 
 */
@KafkaListener(topics = "promotion-return", groupId = "booking-group")
public void checkCode(String code) {
	if(code.equalsIgnoreCase("correct")) {
		discount=true;
	}
}
@GetMapping("/discount_code")
public void discount (@RequestParam ("code")String code) {
if(use_promotion){
	messageProducer.sendMessage("promotion",code);
}
}

@GetMapping("/hold")
public  void holdBooking(@RequestParam ("name") String name,@RequestParam("username") String user) {
	messageProducer.sendMessage("authen",user);
	if(authen_pass) {
	messageProducer.sendMessage("hold-tickets",name);
	System.out.println("hold ticket sent");
	messageProducer.sendMessage("Payment", "Payment info");
	}else {
	 System.out.println("Please login before continuing");
	}
	paid=true;
}
	
	
@GetMapping("/booked")
public void book(@RequestParam ("name") String name) {
	if(paid) {
	messageProducer.sendMessage("book-tickets",name);
	messageProducer.sendMessage("notification", "Booking Success");
	System.out.println("book success pass");
	
 }
else {
	System.out.println("Payment failed");
}
}
}
