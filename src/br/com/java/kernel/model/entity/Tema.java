package br.com.java.kernel.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Entidade que faz a criação da tabela TEMA no banco de dados 
 * 
 */
@Entity
@Table(name="TEMA")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TEMA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTema;

	@Column(name="ATIVO")
	private boolean ativo;

	@Column(name="NOME")
	private String nome;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="CODIGO")
	private String codTema;
	
	

	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	@OneToMany(mappedBy="tema")
	private List<Assunto> ListaAssunto;

	@ManyToMany(mappedBy="listaTema")
	private List<Usuario> listaUsuario;
	
	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public Tema() {
	}


	public Integer getIdTema() {
		return idTema;
	}


	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
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


	public String getCodTema() {
		return codTema;
	}


	public void setCodTema(String codTema) {
		this.codTema = codTema;
	}


	public List<Assunto> getListaAssunto() {
		return ListaAssunto;
	}


	public void setListaAssunto(List<Assunto> listaAssunto) {
		ListaAssunto = listaAssunto;
	}


	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}


	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}



	
	
	

}