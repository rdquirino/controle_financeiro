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

/**
 * Entidade que faz a criação da tabela ENDERECO no banco de dados
 * 
 */
@Entity
@Table(name = "CONTA")
public class Conta extends GenEntidade {
	private static final long serialVersionUID = 1L;
	
		
	
	@Id
	@Column(name = "ID_CONTA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idConta;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "STATUS")
	private Boolean status;
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "MES")
	private String mes;

	@Column(name = "VALOR_CONTA")
	private double valorConta;

	@Column(name = "VALOR_PAGO")
	private double valorPago;

	@Column(name = "DATA_VENCIMENTO")
	private Date dataVencimento;

	@Column(name = "DATA_PAGAMENTO")
	private Date dataPagamento;

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

	public Conta() {
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValorConta() {
		return valorConta;
	}

	public void setValorConta(double valorConta) {
		this.valorConta = valorConta;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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


	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

}