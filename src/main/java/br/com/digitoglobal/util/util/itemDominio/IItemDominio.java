package br.com.digitoglobal.util.util.itemDominio;

<<<<<<< HEAD
import br.com.digitoglobal.util.bean.model.Dominio;
=======
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.service.ItemDominioService;
import me.dabpessoa.framework.service.SpringContextProvider;

public interface IItemDominio {
<<<<<<< HEAD

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
=======
	ItemDominio getItem(boolean deveBuscarDoBancoDeDados);
	ItemDominio getItem();
	void preencherItemAPartirDoBancoDeDados();

	default ItemDominio buscarNoBancoDeDados(String label, String nomeDominio, String nomeModulo, SpringContextProvider springContextProvider) {
		if (label == null) return null;
		ItemDominioService itemDominioService = springContextProvider.getBean(ItemDominioService.class);
		return itemDominioService.findByLabelAndDominioAndModulo(label, nomeDominio, nomeModulo);
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
	}

}
