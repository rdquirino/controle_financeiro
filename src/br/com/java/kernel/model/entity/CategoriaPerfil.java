package br.com.java.kernel.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * Entidade que faz a criação da tabela CATEGORIA_PERFIL no banco de dados 
 * 
 */
@Entity
@Table(name="CATEGORIA_PERFIL")
public class CategoriaPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CATEGORIA_PERFIL")
	private Integer idCategoriaPerfil;

	@Column(name="NOME")
	private String nome;
	
	@Column(name="ATIVO")
	private boolean ativo;

	@Column(name="DESCRICAO")
	private String descricao;
	
	
	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	@ManyToMany(mappedBy="listaCategoriaPerfil")
	private List<Perfil> listaPerfil;

	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public CategoriaPerfil() {
	}

	public Integer getIdCategoriaPerfil() {
		return idCategoriaPerfil;
	}

	public void setIdCategoriaPerfil(Integer idCategoriaPerfil) {
		this.idCategoriaPerfil = idCategoriaPerfil;
	}

	public String getNome() {	
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}



}