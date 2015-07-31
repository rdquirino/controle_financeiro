package br.com.java.kernel.model.service;

import java.util.List;

import br.com.java.kernel.model.entity.Despesa;


public interface DespesaService {

	public Despesa buscaPorLoginESenha(String login, String senha);
	public Despesa buscaPorEmail(String email);
	public Despesa atualizaDespesa(Despesa despesa);
	public boolean salvar(Despesa despesa);
	public List<Despesa> listarTodos();
	public void excluir(Despesa despesa);
	public List<Despesa> buscaPorMes(String mes);
}
