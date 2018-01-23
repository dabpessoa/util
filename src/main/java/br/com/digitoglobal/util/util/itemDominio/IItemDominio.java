package br.com.digitoglobal.util.util.itemDominio;

import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.service.ItemDominioService;
import me.dabpessoa.framework.service.SpringContextProvider;

public interface IItemDominio {

	ItemDominio getItem();
	ItemDominio getItem(Dominio dominio);
	ItemDominio getItem(boolean deveBuscarDoBancoDeDados);
	ItemDominio getItem(Dominio dominio, boolean deveBuscarDoBancoDeDados);

	default ItemDominio buscarItemAPartirDoBancoDeDados(String label, Dominio dominio, SpringContextProvider springContextProvider) {
		if (dominio == null) {
			throw new RuntimeException("Não é possível consultar 'Item de Domínio' pois a identificação do 'Domínio' está vazia.");
		}
		if (label == null) {
			throw new RuntimeException("Não é possível consultar 'Item de Domínio' pois o label está vazio.");
		}

		ItemDominioService itemDominioService = springContextProvider.getBean(ItemDominioService.class);
		return itemDominioService.findByLabelAndCodigoDominio(label, dominio.getId());
	}

}
