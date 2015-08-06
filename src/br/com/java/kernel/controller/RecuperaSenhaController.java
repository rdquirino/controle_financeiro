package br.com.java.kernel.controller;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.java.kernel.model.entity.seguranca.Usuario;
import br.com.java.kernel.model.service.UsuarioService;
import br.com.java.kernel.util.EmailUtil;
import br.com.java.kernel.util.Md5Util;

@Controller(value="recuperaSenhaController")
@Scope("request")
public class RecuperaSenhaController {
	
	private static final int SENHA_LENGHT = 6;

	private String email;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public String recuperarSenha() {
		Usuario usuario = usuarioService.buscaPorEmail(getEmail());
		if (usuario != null) {
			String novaSenha = RandomStringUtils.randomAlphabetic(SENHA_LENGHT);
			boolean envioOk = emailUtil.sendEmail("Sua nova senha é: " + novaSenha, "Recuperação de senha", email);
			if (envioOk) {
				try {
					usuario.setSenha(Md5Util.hashMd5(novaSenha));
					usuarioService.atualizaUsuario(usuario);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmailUtil getEmailUtil() {
		return emailUtil;
	}

	public void setEmailUtil(EmailUtil emailUtil) {
		this.emailUtil = emailUtil;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
