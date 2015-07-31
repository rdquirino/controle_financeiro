package br.com.java.kernel.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.java.kernel.model.dao.ContaDao;
import br.com.java.kernel.model.dao.DaoGenerico;
import br.com.java.kernel.model.entity.Conta;
import br.com.java.kernel.model.service.ContaService;

@Component
@Service("contaService")
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaDao contafaDao;
	
	@Resource
    private DaoGenerico<Conta, Integer> contaDao;

	public DaoGenerico<Conta, Integer> getContaDao() {
		return contaDao;
	}

	public void setContaDao(DaoGenerico<Conta, Integer> contaDao) {
		this.contaDao = contaDao;
	}

	@Override
	public Conta buscaPorLoginESenha(String login, String senha) {
		Conta conta = null;
        String query = "SELECT u FROM Conta u WHERE u.dataDelecao is null AND u.login=:login and u.senha=:senha";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", login);
        params.put("senha", senha);
        conta = getContaDao().pesqParam(query , params);
        return conta;
	}

	@Override
	public Conta buscaPorEmail(String email) {
		Conta conta = null;
        String query = "SELECT u FROM Conta u WHERE u.dataDelecao is null AND u.email=:email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        conta = getContaDao().pesqParam(query , params);
        return conta;
	}
	
	@Override
	public List<Conta> buscaPorMes(String mes) {
        List<Conta> listaConta = new ArrayList<Conta>(); 
		String query = "SELECT u FROM Conta u WHERE u.mes ="+ "'" +mes+"'";
       
		listaConta = contaDao.listPesq(query);
		
		
		
        return listaConta;
	}


	@Override
	public Conta atualizaConta(Conta conta) {
		return getContaDao().atualizar(conta);
	}
	
	@Override
	public void excluir(Conta conta){
		contafaDao.excluir(conta);
	}

	@Override
	public boolean salvar(Conta conta) {
		if(getContaDao().salvar(conta)){
			return true;
		}else{
			return false;
		}
		
	 
	}
	
	@Override
	public List<Conta> listarTodos() {
		return getContaDao().todos();
		
	}
}
