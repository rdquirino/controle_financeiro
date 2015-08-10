package br.com.java.kernel.model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import br.com.java.kernel.model.entity.generico.GenEntidade;

/**
 * Entidade que faz a criação da tabela USUARIO no banco de dados 
 * 
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name="USUARIO")
@NamedQueries({
	  @NamedQuery(name = "Usuario.buscaPorLogin", query = "SELECT usu FROM Usuario usu WHERE usu.login = :username")})
public class Usuario extends GenEntidade implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ATIVO")
	private Boolean ativo;

	@Column(name="TERMOS")
	private Boolean termos;
	
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
	
	@ManyToMany(mappedBy = "listaUsuario")
	private List<Perfil> listaPerfil = new ArrayList<Perfil>();
	
	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getTermos() {
		return termos;
	}

	public void setTermos(Boolean termos) {
		this.termos = termos;
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

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		for (Perfil p : listaPerfil)
			result.add(new GrantedAuthorityImpl(p.getNome()));
		return result;
	}
	
	@Override
	@Transient
	public String getPassword() {
		return this.senha;
	}

	@Override
	@Transient
	public String getUsername() {
		return this.login;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
	}
	
	
	

}