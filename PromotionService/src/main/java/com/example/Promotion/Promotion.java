package com.example.Promotion;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="tbl_promotion_0")
public class Promotion {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String code;
	String info;
	String status;
	
	public Promotion() {
	}
	
	
	public Promotion(Integer id, String code, String info,String status) {
		super();
		this.id = id;
		this.code = code;
		this.info = info;
		this.status=status;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String name) {
		this.code = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
