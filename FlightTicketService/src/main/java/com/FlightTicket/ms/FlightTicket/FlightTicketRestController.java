package com.FlightTicket.ms.FlightTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

@RestController

public class FlightTicketRestController {

    @Autowired
    TicketService service;
    @Autowired
    TicketRepository repo;
    
    //http://localhost:8080/findTickets?name=
    @GetMapping("/findTickets")
    public Tickets findTicketsByName(@RequestParam String name) {
      Tickets user = service.findTicketsByName(name) ;
      return user;
    }

    // http://localhost:8080/api/Ticketss
    @GetMapping(value = "/Ticketss", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tickets>> getResponseJsonContent() {
        List<Tickets> Ticketss = service.getAllTickets();
        return ResponseEntity.ok(Ticketss);
    }

    // http://localhost:8080/api/Tickets?name=
    @GetMapping(value = "/Tickets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tickets> getTicketsByName(@RequestParam String name) {
        Tickets cust = service.findTicketsByName(name);
        return ResponseEntity.ok(cust);
    }


    
 
}
    

