package br.com.java.kernel.model.entity.seguranca;

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
 * Entidade que faz a cria��o da tabela USUARIO no banco de dados 
 * 
 */
@Entity
@Table(name="PERFIL")
public class Perfil extends GenEntidade {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;

	@Column(name="ATIVO")
	private boolean ativo;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TERMOS")
	private boolean termos;
	
	@Column(name="FOTO")
	private byte[] foto;

	@Column(name="LOGIN")
	private String login;

	@Column(name="COD_SEGURACA")
	private String codSeguranca;
	
	@Column(name="NOME")
	private String nome;

	@Column(name="SENHA")
	private String senha;

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
	

	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public Perfil() {
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	
	public boolean isTermos() {
		return termos;
	}

	public void setTermos(boolean termos) {
		this.termos = termos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	
}