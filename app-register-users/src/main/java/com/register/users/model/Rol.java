package com.register.users.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Rol(Long id, String name) {
		super();
		id = id;
		this.name = name;
	}
	public Rol() {
		super();
	}
	public Rol(String name) {
		super();
		this.name = name;
	}	
	
}
