package com.register.users.DTO;

public class UserRegisterDTO {

	private Long id;
	private String name;	
	private String lastName;	
	private String email;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRegisterDTO(Long id, String name, String lastName, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public UserRegisterDTO(String name, String lastName, String email, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public UserRegisterDTO(String email) {
		super();
		this.email = email;
	}
	public UserRegisterDTO() {
		super();
	}
	
	

}
