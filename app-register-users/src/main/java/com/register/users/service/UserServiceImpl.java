package com.register.users.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.register.users.DTO.UserRegisterDTO;
import com.register.users.model.Rol;
import com.register.users.model.Userd;
import com.register.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Userd save(UserRegisterDTO userRegisterDTO) {
		Userd user = new Userd(userRegisterDTO.getName(),userRegisterDTO.getLastName(), 
				userRegisterDTO.getEmail(),
				new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword()),			 
				Arrays.asList(new Rol("ROLE_USER")));		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Userd user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Usuario o password invalido");
		}
		
		return new User(user.getEmail(),user.getPassword(), mapearAutoridadesRoles(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	public List<Userd> listarUsuarios() {
		return userRepository.findAll();
	}

	@Override
	public boolean get(UserRegisterDTO userRegisterDTO) {		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 		
		Userd data = userRepository.findByEmail(userRegisterDTO.getEmail());		
		if(encoder.matches(userRegisterDTO.getPassword(), data.getPassword())) {			
			return true;
		}		
		return false;
	}
}
