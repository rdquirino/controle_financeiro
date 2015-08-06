package br.com.java.kernel.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.java.kernel.model.entity.generico.GenEntidade;
import br.com.java.kernel.model.entity.seguranca.Usuario;


/**
 * Entidade que faz a criação da tabela ENDERECO no banco de dados 
 * 
 */
@Entity
@Table(name="ENDERECO")
public class Endereco extends GenEntidade {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ENDERECO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEndereco;

	
	@Column(name="RUA")
	private String rua;

	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="PAIS")
	private String pais;
	

	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	
	@OneToMany
	private List<Usuario> ListaUsuario;

	/**
	 * GET e SET  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	

	public Endereco() {
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Usuario> getListaUsuario() {
		return ListaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		ListaUsuario = listaUsuario;
	}
	
	
	

}