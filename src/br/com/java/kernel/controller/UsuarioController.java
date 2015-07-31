package br.com.java.kernel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.java.kernel.model.entity.Usuario;
import br.com.java.kernel.model.service.UsuarioService;

@Controller(value="usuarioController")
@Scope("request")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario = new Usuario();
	
	private String senha2;
	
	private String msg = "Mensagem";
	
	
	public String inserir() {
		if(usuarioService.salvar(usuario)){
			return "login.faces?faces-redirect=true";
		}else{
			usuario = new Usuario();
			return "cadastro.faces?faces-redirect=true";
		}
		
		
		
		
	}
	

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getSenha2() {
		return senha2;
	}


	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
}
