
package com.FlightTicket.ms.FlightTicket;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class FlightTicketController {
	
	@Autowired
	TicketService service;
	
	@KafkaListener(topics = "hold-tickets", groupId = "booking-group")
	public void holdTicket(String name) {
		if(name.equalsIgnoreCase(service.findTicketByName(name))){
			service.setStatus(name,"hold");
		}
	
	}
	@KafkaListener(topics = "book-tickets", groupId = "booking-group")
	public void bookTicket(String name) {
		if(name.equalsIgnoreCase(service.findTicketByName(name))){
			service.setStatus(name,"Booked");
		}
	
	}
}