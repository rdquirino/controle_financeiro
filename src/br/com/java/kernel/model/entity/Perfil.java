package br.com.java.kernel.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Entidade que faz a criação da tabela PERFIL no banco de dados 
 * 
 */
@Entity
@Table(name="PERFIL")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PERFIL")
	private Integer idPerfil;


	@Column(name="NOME")
	private String nome;
	
	@Column(name="ATIVO")
	private boolean ativo;

	@Column(name="DESCRICAO")
	private String descricao;
	
	
	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	@OneToMany(mappedBy="perfil")
	private List<Usuario> listaUsuario;

	
	@ManyToMany
	@JoinTable(name="PERFIL_CATEGORIA_PERFIL")
	private List<CategoriaPerfil> listaCategoriaPerfil;
	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public Perfil() {
	}


	public Integer getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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


	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}


	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}


	public List<CategoriaPerfil> getListaCategoriaPerfil() {
		return listaCategoriaPerfil;
	}


	public void setListaCategoriaPerfil(List<CategoriaPerfil> listaCategoriaPerfil) {
		this.listaCategoriaPerfil = listaCategoriaPerfil;
	}

	
	


}