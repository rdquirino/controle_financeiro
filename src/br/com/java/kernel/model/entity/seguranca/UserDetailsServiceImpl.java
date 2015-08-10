package br.com.java.kernel.model.entity.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import br.com.java.kernel.model.entity.Usuario;
import br.com.java.kernel.model.service.impl.UsuarioServiceImpl;

/**
 * Classe responsável pela consulta do usuário na base de dados.
 * Bean responsável pelas operações de negócio da entidade usuário.
 * @author rodrigo.fujioka Data de criação: 01/04/2015 as 16:19:20
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioServiceImpl usuarioService;

  
  /**
   * Método que carrega  o usuário pelo username e converte em um objeto do tipo
   * userDetails.
   */
  public UserDetails loadUserByUsername(String username) {	 
	  Usuario retorno = usuarioService.buscaPorLogin(username);	  	  
	  return (UserDetails) retorno;
  }
  
}

