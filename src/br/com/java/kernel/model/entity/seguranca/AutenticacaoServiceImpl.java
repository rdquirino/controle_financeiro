
package br.com.java.kernel.model.entity.seguranca;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.java.kernel.model.entity.Usuario;


@Component
@Service("authenticationService")
public class AutenticacaoServiceImpl implements AuthenticationProvider, Serializable {

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	/**
	 * @param 
	 */
	public boolean login(String login, String senha, Collection<GrantedAuthority> autoridades) {
	    try {
	    	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login,senha,autoridades);
	    	Authentication authenticate = authenticationManager.authenticate(token);
	    	SecurityContextHolder.getContext().setAuthentication(authenticate);
	    	return true;
	    }
	    catch (AuthenticationException e) {
	    	e.printStackTrace();
	    }
	    return false; 
	  }

	  public void logout() {
	    SecurityContextHolder.getContext().setAuthentication(null);
	    invalidateSession();
	  }

	  public Usuario getUsuarioLogado() {
	    return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  }

	  private void invalidateSession() {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
	    session.invalidate();
	  }
	  
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Override
	public Authentication authenticate(Authentication arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
