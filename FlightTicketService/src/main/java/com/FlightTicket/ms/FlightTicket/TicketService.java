package com.FlightTicket.ms.FlightTicket;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;



import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;


@Service
public class TicketService implements TicketServiceInterface {
//	
	@Autowired
	 private TicketRepository repo;
//		public Tickets findTicketsByName(String TicketsName) {
//			Tickets result = (Tickets) repo.findByName(TicketsName);
//			System.out.printf("%d) name:%s, email:%s %n", result.getId(), result.getName(), result.getEmail());
//			return result;
//		}
//
//
//	@Override
//	public Tickets searchTicketsByName(String name) {
//		 Tickets cust = new Tickets(2, "boonset", "Napat.boons@dome.tu.ac.th");
//		 
//	     return cust;
//		
//	}
//
//	@Override
//	public List<Tickets> getAllTickets() {
//		List<Tickets> list1 = new ArrayList<Tickets>();
//		list1.add(new Tickets(1,"napat","u1@gmail.com"));
//		list1.add(new Tickets(2,"boonset","u2@gmail.com"));
//		
//		return list1;
//	}
//
//
//	@Override
//	public List<Tickets> findByName(String name) {
//		 return repo.findByName(name);
//	}
//
	 @Override
	 public String findTicketByName(String TicketsName) {
		    List<Tickets> Tickets = repo.findByName(TicketsName);
		    if (!Tickets.isEmpty()) {
		        Tickets result = Tickets.get(0);
		        String name =result.getName();
		        return name;
		    } else {
		        // กรณีไม่พบ Tickets
		        return "";
		    }
		}

	    public void setStatus(String name,String status) {
	    	 List<Tickets> Tickets = repo.findByName(name);
			    if (!Tickets.isEmpty()) {
			        Tickets result = Tickets.get(0);
			       result.setStatus(status);
			       repo.save(result);
			    }
	    }

	    @Override
	    public List<Tickets> getAllTickets() {
	        // Implement your logic to fetch all Ticketss from the repository
	        return repo.findAll();
	    }

	    @Override
	    public List<Tickets> findByName(String name) {
	        // Implement your logic to find Ticketss by name from the repository
	        return repo.findByName(name);
	    }


	@Override
	public List<Tickets> findByName(String name, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public com.azure.core.http.rest.Page<Tickets> findByName(String name, Pageable pageable) {
		return null;
	}
	
	public Tickets findTicketsByName(String username) {
	    List<Tickets> users = repo.findByName(username);
	    if (!users.isEmpty()) {
	        Tickets result = users.get(0);
	        System.out.printf("%d) name:%s, email:%s %n", result.getId(), result.getName(), result.getInfo());
	        return result;
	    } else {
	        // กรณีไม่พบ Customer
	        return null;
	    }
	}


	
	

}