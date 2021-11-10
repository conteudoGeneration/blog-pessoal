package com.generation.blogpessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;

/**
 * @author Marcelo Barboza
 *  Anotação @Service deve sempre ser usada em classes de serviços, ela transforma a classe em um componeten que será genrenciado pelo Spring
 * 
 * */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = repository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return usuario.map(UserDetailsImpl::new).get();
	}
}