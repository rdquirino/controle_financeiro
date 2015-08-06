package br.com.java.kernel.model.service;

import br.com.java.kernel.model.entity.seguranca.Usuario;


public interface UsuarioService {

	public Usuario buscaPorLoginESenha(String login, String senha);
	public Usuario buscaPorEmail(String email);
	public Usuario atualizaUsuario(Usuario usuario);
	public boolean salvar(Usuario usuario);
}
