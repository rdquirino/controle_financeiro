package br.com.java.kernel.model.entity.generico;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class GenEntidade implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_DELECAO")
	private Date dataDelecao;
}
