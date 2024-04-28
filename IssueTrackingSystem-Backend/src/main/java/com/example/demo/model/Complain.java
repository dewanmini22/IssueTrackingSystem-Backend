package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="complain")
public class Complain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email_id")
	private String email_id;
	
	@Column(name = "reported_issue")
	private String reported_issue;
	
	@Column(name = "status")
	private String status;
	
	public Complain(){
		
	}
	public Complain(String name, String email_id, String reported_issue, String status) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.reported_issue = reported_issue;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getReported_issue() {
		return reported_issue;
	}
	public void setReported_issue(String reported_issue) {
		this.reported_issue = reported_issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
