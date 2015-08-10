package br.com.java.kernel.controller;

import java.io.IOException;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.java.kernel.model.entity.Usuario;
import br.com.java.kernel.model.entity.seguranca.AutenticacaoServiceImpl;
import br.com.java.kernel.model.service.impl.UsuarioServiceImpl;
import br.com.java.kernel.util.MessageUtil;
import br.com.java.kernel.util.NavegationUtil;

@Controller
@Scope(value = "session")
public class LoginController {

	@Autowired
	@ManagedProperty(value = "#{autenticacaoServiceImpl}")
	private AutenticacaoServiceImpl authenticationService;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	private String userName;
	private String password;

	private NavegationUtil navegation = new NavegationUtil();
	private MessageUtil messageUtil = new MessageUtil();

	/**
	 * Usado para login no sistema, libera o acesso do usuário caso ele tem
	 * algum perfil
	 * 
	 * @throws IOException
	 */
	public void login() throws IOException {
		Usuario usuario = new Usuario();
		if (!userName.equals("") && !password.equals("")) {

			usuario = usuarioService.buscaPorLogin(userName);

			if (usuario != null) {

				if (usuario.getSenha().equals(password) && !usuario.getListaPerfil().isEmpty()) {
					boolean success = authenticationService.login(userName, password, usuario.getAuthorities());

					if (!success) {
						messageUtil.messageInfo("<MENSAGEM> Pagina não enccontrada");
					} else {
						navegation.redirect("/paginas/index.xhtml");
					}
				} else {
					messageUtil.messageFatal("<MENSAGEM>  Senha invalida");
				}
			} else {
				messageUtil.messageFatal("<MENSAGEM> Usuário não encontrado");
			}

		} else {
			messageUtil.messageInfo("<MENSAGEM> Login ou senha não informado");
		}

	}

	public String logout() {
		authenticationService.logout();
		return "login";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
