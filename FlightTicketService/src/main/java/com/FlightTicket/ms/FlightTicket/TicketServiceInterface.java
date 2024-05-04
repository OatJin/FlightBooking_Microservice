package com.FlightTicket.ms.FlightTicket;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

import com.azure.core.http.rest.Page;





public interface TicketServiceInterface {
	
	
	List<Tickets> getAllTickets();
	public List<Tickets> findByName(String name) ;
	

	String findTicketByName(String ticketName);
    List<Tickets> findByName(String name, Sort sort);
    Page<Tickets> findByName(String name, Pageable pageable);


}
