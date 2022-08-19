package com.example.Agent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("addresses")
public class Address {
	@Id
	private Long id;
	private String street;
	private String state;
	private String city;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(Long id, String street, String state, String city) {
		super();
		this.id = id;
		this.street = street;
		this.state = state;
		this.city = city;
	}
	public Address() {}
	
}
