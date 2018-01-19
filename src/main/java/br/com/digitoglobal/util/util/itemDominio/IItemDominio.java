package br.com.digitoglobal.util.util.itemDominio;

import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.service.ItemDominioService;
import me.dabpessoa.framework.service.SpringContextProvider;

public interface IItemDominio {
	ItemDominio getItem(boolean deveBuscarDoBancoDeDados);
	ItemDominio getItem();
	void preencherItemAPartirDoBancoDeDados();

	default ItemDominio buscarNoBancoDeDados(String label, String nomeDominio, String nomeModulo, SpringContextProvider springContextProvider) {
		if (label == null) return null;
		ItemDominioService itemDominioService = springContextProvider.getBean(ItemDominioService.class);
		return itemDominioService.findByLabelAndDominioAndModulo(label, nomeDominio, nomeModulo);
	}

}
