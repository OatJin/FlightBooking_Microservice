package com.FlightTicket.ms.FlightTicket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Tickets, Integer> {

    List<Tickets> findByName(String name);

    Tickets findTicketsByName(String tickName);


    Page<Tickets> findByName(String name, Pageable pageable);
}
