package br.senai.sc.ti20122n.pw.lanchonetenm.converter;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ti20122n.pw.lanchonetenm.mb.LojaMB;
import br.senai.sc.ti20122n.pw.lanchonetenm.model.entity.Loja;

@FacesConverter(forClass = Loja.class)
public class LojaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		ELContext elContext = facesContext.getELContext();
		ELResolver elResolver = elContext.getELResolver();

		LojaMB lojaMB = (LojaMB) elResolver.getValue(elContext, null, "lojaMB");

		Long id = Long.parseLong(value);
		return lojaMB.buscarLojaPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object object) {
		Loja loja = (Loja) object;
		return String.valueOf(loja.getId());
	}
}
