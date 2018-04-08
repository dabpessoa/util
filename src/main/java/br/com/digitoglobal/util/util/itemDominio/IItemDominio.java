package br.com.digitoglobal.util.util.itemDominio;

import br.com.digitoglobal.accesscontrol.model.Modulo;
import br.com.digitoglobal.accesscontrol.service.ModuloService;
import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.service.DominioService;
import br.com.digitoglobal.util.service.ItemDominioService;
import me.dabpessoa.framework.service.SpringContextProvider;

public interface IItemDominio {

	ItemDominio getItem();
	ItemDominio getItem(boolean deveBuscarDoBancoDeDados);
	ItemDominio getItem(Dominio dominio);
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

	default Dominio findDominio(Modulo modulo, String labelDominio, SpringContextProvider springContextProvider) {
		if (modulo == null || modulo.getId() == null) {
			throw new RuntimeException("Não é possível consultar um Domínio pois a identificação do múdulo está vazia. Label do Domínio: "+labelDominio);
		}

		DominioService dominioService = springContextProvider.getBean(DominioService.class);
		Dominio dominio = dominioService.findByLabelAndCodigoModulo(labelDominio, modulo.getId());

		if (dominio == null) {
			throw new RuntimeException("O label '"+labelDominio+"' não existe na tabela de domínios no banco de dados. Favor adicioná-lo.");
		}

		return dominio;
	}

	default Modulo findModulo(String labelModulo, SpringContextProvider springContextProvider) {
		if (labelModulo == null) {
			throw new RuntimeException("Não é possível consultar 'Módulo' pois o label está vazio.");
		}

		ModuloService moduloService = springContextProvider.getBean(ModuloService.class);
		Modulo modulo = moduloService.findByLabel(labelModulo);

		return modulo;
	}

}
