package com.register.users.model;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="users", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Userd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name") 
	private String name;
	
	@Column(name="lastName") 
	private String lastName;
	
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinTable(
			name="users_rol",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="rol_id", referencedColumnName="id")
			)
	private Collection <Rol> roles;
	
	
	public Userd(Long id, String name, String lastName, String email, String password, Collection<Rol> roles) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
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
	public Collection<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
	public Userd(String name, String lastName, String email, String password, Collection<Rol> roles) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public Userd() {
		super();
	}
	
	
}
