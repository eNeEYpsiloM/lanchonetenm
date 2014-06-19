package br.senai.sc.ti20122n.pw.lanchonetenm.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.senai.sc.ti20122n.pw.lanchonetenm.model.entity.Loja;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Loja loja;
	private String prodTipo;
	private String descricao;
	private String marca;
	private String valor;
	private Date dataEstoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String getProdTipo() {
		return prodTipo;
	}

	public void setProdTipo(String prodTipo) {
		this.prodTipo = prodTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getDataEstoque() {
		return dataEstoque;
	}

	public void setDataEstoque(Date dataEstoque) {
		this.dataEstoque = dataEstoque;
	}

}
