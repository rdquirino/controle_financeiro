package br.com.java.kernel.model.entity.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import br.com.java.kernel.model.entity.Usuario;
import br.com.java.kernel.model.service.impl.UsuarioServiceImpl;

/**
 * Classe respons�vel pela consulta do usu�rio na base de dados.
 * Bean respons�vel pelas opera��es de neg�cio da entidade usu�rio.
 * @author rodrigo.fujioka Data de cria��o: 01/04/2015 as 16:19:20
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioServiceImpl usuarioService;

  
  /**
   * M�todo que carrega  o usu�rio pelo username e converte em um objeto do tipo
   * userDetails.
   */
  public UserDetails loadUserByUsername(String username) {	 
	  Usuario retorno = usuarioService.buscaPorLogin(username);	  	  
	  return (UserDetails) retorno;
  }
  
}

