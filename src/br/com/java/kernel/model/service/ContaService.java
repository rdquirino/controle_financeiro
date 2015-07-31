package br.com.java.kernel.model.service;

import java.util.List;

import br.com.java.kernel.model.entity.Conta;


public interface ContaService {

	public Conta buscaPorLoginESenha(String login, String senha);
	public Conta buscaPorEmail(String email);
	public Conta atualizaConta(Conta conta);
	public boolean salvar(Conta conta);
	public List<Conta> listarTodos();
	public void excluir(Conta conta);
	public List<Conta> buscaPorMes(String mes);
}
