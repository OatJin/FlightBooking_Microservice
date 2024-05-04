package com.FlightTicket.ms.FlightTicket;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="tbl_customers_0")
public class Tickets {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String name;
	String info;
	String status;
	public Tickets() {
	}
	
	
	public Tickets(Integer id, String name, String info, String status) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setStatus(String s) {
		this.status=s;
	}
	public String getStatus() {
		return status;
	}
	
}

