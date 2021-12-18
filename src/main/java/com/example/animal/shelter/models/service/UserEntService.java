package com.example.animal.shelter.models.service;


import java.util.List;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.animal.shelter.models.dao.IUserDao;
import com.example.animal.shelter.models.entity.UserEnt;

//Interfaz de spring security
@Service
public class UserEntService implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UserEntService.class);

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEnt user = userDao.findByUsername(username);
		
	if(user == null) {
		logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema");
		throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema"); 
	}
	
	
	List<GrantedAuthority> authorities = user.getRoles()
			.stream()
			.map(role -> new SimpleGrantedAuthority(role.getName()))
			.peek(authority->logger.info("Role: "+authority.getAuthority()))
			.collect(Collectors.toList());
	
	return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
}
	