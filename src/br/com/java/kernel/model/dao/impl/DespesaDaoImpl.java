package br.com.java.kernel.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.kernel.model.dao.DespesaDao;
import br.com.java.kernel.model.entity.Despesa;


@Repository("despesaDao")
public class DespesaDaoImpl extends DaoGenericoImp<Despesa, Integer> implements DespesaDao {

}
