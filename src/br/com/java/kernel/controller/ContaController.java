package br.com.java.kernel.controller;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.java.kernel.model.entity.Conta;
import br.com.java.kernel.model.service.ContaService;

@Controller(value="contaController")
@Scope("session")
public class ContaController {

	
	
	@Autowired
	private ContaService contaService;
	
	private Conta conta = new Conta();
	
	private Conta contaSelecionada = new Conta();
	private String senha2;
	
	private boolean flagBotao = false;
	
	private String msg = "Mensagem";
	
	private boolean opcao = true;
	
	private List<Conta> listaConta = new ArrayList<Conta>();
	
	private Double valorToral= 0.0;
	
/*	@PostConstruct
	public void init(){
		
		listar();
	}
	*/
	public void inserir() {
		
		contaService.salvar(conta);
		listaConta = contaService.listarTodos();
		conta = new Conta();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK!", "Contra cadastrada"));
		
	}
	
	
	public void limpar() {
		conta = new Conta();
	}
	
	public void excluir() {
		contaService.excluir(getContaSelecionada());
		listaConta = contaService.listarTodos();
		valorToral = valorToral - contaSelecionada.getValorConta();
		RequestContext.getCurrentInstance().update("tabViewIndex:tabConta:formTabelaConta");
	}
	
	public void alterar(){
		System.out.println("teste");
		contaService.atualizaConta(contaSelecionada);
		listar();
	}
	public void habilitarOpcao(boolean opcao){
		this.opcao = opcao;
		if(opcao){
			contaSelecionada = new Conta();
		}
	}
	
	public void listar(){
		
		listaConta = contaService.listarTodos();
		
		for(Conta conta : listaConta){
			
			if(conta.getValorConta() <= conta.getValorPago()){
				
				conta.setStatus(true);
			}else{
				conta.setStatus(false);
			}
		}
		
		calcularValorToral();
	}
	
	public void calcularValorToral(){
		
		for(Conta c : listaConta){
			
			valorToral = (valorToral + c.getValorConta());
		}
	}
	
	public void listaContaMes(String mes){
		
		if(mes.equals("todas")){
			this.listaConta = contaService.listarTodos();
			
		}else{
		this.listaConta = contaService.buscaPorMes(mes);
		
		}
		RequestContext.getCurrentInstance().update("tabViewIndex");
	}
	
	
	public ContaService getContaService() {
		return contaService;
	}

	public void setContaService(ContaService contaService) {
		this.contaService = contaService;
	}

	


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
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


	public List<Conta> getListaConta() {
		return listaConta;
	}


	public void setListaConta(List<Conta> listaConta) {
		this.listaConta = listaConta;
	}


	public Conta getContaSelecionada() {
		return contaSelecionada;
	}


	public void setContaSelecionada(Conta contaSelecionada) {
		this.contaSelecionada = contaSelecionada;
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
