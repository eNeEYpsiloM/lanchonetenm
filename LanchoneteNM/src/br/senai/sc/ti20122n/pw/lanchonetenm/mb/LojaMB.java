package br.senai.sc.ti20122n.pw.lanchonetenm.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti20122n.pw.lanchonetenm.model.entity.Loja;
import br.senai.sc.ti20122n.pw.lanchonetenm.util.FacesContextUtil;

@ManagedBean
public class LojaMB {
	private List<Loja> lojas;
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Loja> getLojas() {
		if (lojas == null) {
			Query query = entityManager.createQuery(
					"select loja from Loja loja",Loja.class);
			lojas = query.getResultList();
		}
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public Loja buscarLojaPorId(Long id) {
		return entityManager.find(Loja.class, id);
	}

}
