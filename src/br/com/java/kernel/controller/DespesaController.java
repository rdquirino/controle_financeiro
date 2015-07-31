package br.com.java.kernel.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.java.kernel.model.entity.Despesa;
import br.com.java.kernel.model.service.DespesaService;

@Controller(value="despesaController")
@Scope("request")
public class DespesaController {

	
	
	@Autowired
	private DespesaService despesaService;
	
	private Despesa despesa = new Despesa();
	
	private Despesa despesaSelecionada = new Despesa();
	private String senha2;
	
	private boolean flagBotao = false;
	
	private String msg = "Mensagem";
	
	private boolean opcao = true;
	
	private List<Despesa> listaDespesa = new ArrayList<Despesa>();
	
	private Double valorToral= 0.0;
	
	@PostConstruct
	public void init(){
		
		listar();
	}
	
	public void inserir() {
		
		despesaService.salvar(despesa);
		listaDespesa = despesaService.listarTodos();
		despesa = new Despesa();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK!", "Contra cadastrada"));
		
	}
	
	
	public void limpar() {
		despesa = new Despesa();
	}
	
	public void excluir() {
		despesaService.excluir(despesaSelecionada);
		listaDespesa = despesaService.listarTodos();
		valorToral = valorToral - despesaSelecionada.getValorDespesa();
		RequestContext.getCurrentInstance().update("tabViewIndex:tabDespesa:formTabelaDespesa");
	}
	
	public void alterar(){
		System.out.println("teste");
		despesaService.atualizaDespesa(despesaSelecionada);
		listar();
	}
	public void habilitarOpcao(boolean opcao){
		this.opcao = opcao;
		if(opcao){
			despesaSelecionada = new Despesa();
		}
	}
	
	public void listar(){
		
		listaDespesa = despesaService.listarTodos();
		
		for(Despesa despesa : listaDespesa){
			
			if(despesa.getValorDespesa() <= despesa.getValorPago()){
				
				despesa.setStatus(true);
			}else{
				despesa.setStatus(false);
			}
		}
		
		calcularValorToral();
	}
	
	public void calcularValorToral(){
		
		for(Despesa c : listaDespesa){
			
			valorToral = (valorToral + c.getValorDespesa());
		}
	}
	
	public void listaDespesaMes(String mes){
		
		if(mes.equals("todas")){
			this.listaDespesa = despesaService.listarTodos();
			
		}else{
		this.listaDespesa = despesaService.buscaPorMes(mes);
		
		}
		RequestContext.getCurrentInstance().update("tabViewIndex");
	}
	
	
	public DespesaService getDespesaService() {
		return despesaService;
	}

	public void setDespesaService(DespesaService despesaService) {
		this.despesaService = despesaService;
	}

	


	public Despesa getDespesa() {
		return despesa;
	}


	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
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


	public List<Despesa> getListaDespesa() {
		return listaDespesa;
	}


	public void setListaDespesa(List<Despesa> listaDespesa) {
		this.listaDespesa = listaDespesa;
	}


	public Despesa getDespesaSelecionada() {
		return despesaSelecionada;
	}


	public void setDespesaSelecionada(Despesa despesaSelecionada) {
		this.despesaSelecionada = despesaSelecionada;
	}


	public boolean isFlagBotao() {
		return flagBotao;
	}


	public void setFlagBotao(boolean flagBotao) {
		this.flagBotao = flagBotao;
	}


	public boolean isOpcao() {
		return opcao;
	}


	public void setOpcao(boolean opcao) {
		this.opcao = opcao;
	}


	public Double getValorToral() {
		return valorToral;
	}


	public void setValorToral(Double valorToral) {
		this.valorToral = valorToral;
	}

	
	
}
