package br.com.java.kernel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Entidade que faz a criação da tabela ASSUNTO no banco de dados 
 * 
 */
@Entity
@Table(name="ASSUNTO")
public class Assunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ASSUNTO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAssunto;

	@Column(name="ATIVO")
	private boolean ativo;

	@Column(name="NOME")
	private String nome;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="CODIGO")
	private String codAssunto;
	
	@Column(name="DESCRICAO")
	private String descricao;

	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	@ManyToOne
	private Tema tema;

	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public Assunto() {
	}

	public Integer getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(Integer idAssunto) {
		this.idAssunto = idAssunto;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodAssunto() {
		return codAssunto;
	}

	public void setCodAssunto(String codAssunto) {
		this.codAssunto = codAssunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}