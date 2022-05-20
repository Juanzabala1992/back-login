package com.register.users.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.register.users.DTO.UserRegisterDTO;
import com.register.users.model.Userd;

public interface UserService extends UserDetailsService {
	public Userd save(UserRegisterDTO userRegisterDTO);
	public boolean get(UserRegisterDTO userRegisterDTO);
	public List<Userd> listarUsuarios();
}
