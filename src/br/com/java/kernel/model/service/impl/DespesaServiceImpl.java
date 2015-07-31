package br.com.java.kernel.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.java.kernel.model.dao.DespesaDao;
import br.com.java.kernel.model.dao.DaoGenerico;
import br.com.java.kernel.model.entity.Despesa;
import br.com.java.kernel.model.service.DespesaService;

@Component
@Service("despesaService")
public class DespesaServiceImpl implements DespesaService {

	@Autowired
	private DespesaDao despesafaDao;
	
	@Resource
    private DaoGenerico<Despesa, Integer> despesaDao;

	public DaoGenerico<Despesa, Integer> getDespesaDao() {
		return despesaDao;
	}

	public void setDespesaDao(DaoGenerico<Despesa, Integer> despesaDao) {
		this.despesaDao = despesaDao;
	}

	@Override
	public Despesa buscaPorLoginESenha(String login, String senha) {
		Despesa despesa = null;
        String query = "SELECT u FROM Despesa u WHERE u.dataDelecao is null AND u.login=:login and u.senha=:senha";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", login);
        params.put("senha", senha);
        despesa = getDespesaDao().pesqParam(query , params);
        return despesa;
	}

	@Override
	public Despesa buscaPorEmail(String email) {
		Despesa despesa = null;
        String query = "SELECT u FROM Despesa u WHERE u.dataDelecao is null AND u.email=:email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        despesa = getDespesaDao().pesqParam(query , params);
        return despesa;
	}
	
	@Override
	public List<Despesa> buscaPorMes(String mes) {
        List<Despesa> listaDespesa = new ArrayList<Despesa>(); 
		String query = "SELECT u FROM Despesa u WHERE u.mes ="+ "'" +mes+"'";
       
		listaDespesa = despesaDao.listPesq(query);
		
		
		
        return listaDespesa;
	}


	@Override
	public Despesa atualizaDespesa(Despesa despesa) {
		return getDespesaDao().atualizar(despesa);
	}
	
	@Override
	public void excluir(Despesa despesa){
		despesafaDao.excluir(despesa);
	}

	@Override
	public boolean salvar(Despesa despesa) {
		if(getDespesaDao().salvar(despesa)){
			return true;
		}else{
			return false;
		}
		
	 
	}
	
	@Override
	public List<Despesa> listarTodos() {
		return getDespesaDao().todos();
		
	}
}
