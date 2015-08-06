package br.com.java.kernel.model.entity;

import java.util.Date;
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
@Table(name = "DESPESA")
public class Despesa extends GenEntidade {
	private static final long serialVersionUID = 1L;
	
		
	
	@Id
	@Column(name = "ID_DESPESA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDespesa;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "STATUS")
	private Boolean status;
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "MES")
	private String mes;

	@Column(name = "VALOR_CONTA")
	private double valorDespesa;

	@Column(name = "VALOR_PAGO")
	private double valorPago;

	@Column(name = "DATA_DESPESA")
	private Date dataDespesa;

	@Column(name = "CENTRO_DE_CUSTO")
	private String centroCusto;

	/**
	 * MAPEAMENTO RELACIONAL ENTRE ENTIDADES XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */

	@OneToMany
	private List<Usuario> ListaUsuario;

	/**
	 * GET e SET XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */

	public Despesa() {
	}

	public Integer getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(Integer idDespesa) {
		this.idDespesa = idDespesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public String getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}

	public List<Usuario> getListaUsuario() {
		return ListaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		ListaUsuario = listaUsuario;
	}

}