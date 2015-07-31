package br.com.java.kernel.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.kernel.model.dao.ContaDao;
import br.com.java.kernel.model.entity.Conta;


@Repository("contaDao")
public class ContaDaoImpl extends DaoGenericoImp<Conta, Integer> implements ContaDao {

}
