package br.com.java.kernel.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.java.kernel.model.entity.generico.GenEntidade;

/**
 * Entidade que faz a criação da tabela USUARIO no banco de dados 
 * 
 */
@Entity
@Table(name="PERFIL")
public class Perfil extends GenEntidade {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idPerfil;

	@Column(name="ATIVO")
	private Boolean ativo;

	@Column(name="NOME")
	private String nome;

	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	
	@ManyToMany
	@JoinTable(
		name="PERFIL_USUARIO"
		, joinColumns={
			@JoinColumn(name="ID_PERFIL")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		)
	private List<Usuario> listaUsuario = new ArrayList<Usuario>();

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	

	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	
	

}