package br.senai.sc.ti20122n.pw.lanchonetenm.mb;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti20122n.pw.lanchonetenm.model.entity.Produto;
import br.senai.sc.ti20122n.pw.lanchonetenm.util.FacesContextUtil;

@ManagedBean
public class ProdutoMB {

	private List<Produto> produtos;
	private Produto produto;
	private EntityManager entityManager;

	@PostConstruct
	private void init() {
		produto = new Produto();
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			Query query = entityManager.createQuery("SELECT p FROM Produto p",
					Produto.class);
			produtos = query.getResultList();
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String salvar() {
		entityManager.merge(produto);

		return "lanchonetelista";
	}

	public String editar(Long id) {
		produto = entityManager.find(Produto.class, id);
		return "lanchoneteform";
	}

	public String excluir(Long id) {
		Produto prod = entityManager.find(Produto.class, id);
		entityManager.remove(prod);
		produtos = null;
		return "lanchonetelista";
	}

}
