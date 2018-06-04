package br.com.digitoglobal.util.service;

import br.com.digitoglobal.accesscontrol.model.Modulo;
import br.com.digitoglobal.accesscontrol.service.ModuloService;
import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.dao.ItemDominioDao;
import me.dabpessoa.framework.exceptions.ApplicationRuntimeException;
import me.dabpessoa.framework.service.GenericAbstractService;
import me.dabpessoa.framework.service.SpringContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDominioService extends GenericAbstractService<ItemDominio, Long, ItemDominioDao, SpringContextProvider> {

	@Autowired ModuloService moduloService;
	@Autowired DominioService dominioService;

	@Override
	public List<ItemDominio> find(ItemDominio entity) {
		return findByHQLEntityFilter(entity, "descricao");
	}

	public ItemDominio findItemDominio(String labelModulo, String labelDominio, String labelItem) {
		Modulo modulo = moduloService.findByLabel(labelModulo);
		Dominio dominio = dominioService.findDominio(modulo, labelDominio);
		return findItemDominio(dominio, labelItem, springContextProvider);
	}

	public ItemDominio findItemDominio(Dominio dominio, String labelItem, SpringContextProvider springContextProvider) {
		ItemDominio itemDominio = findItemDominio(labelItem, dominio);
		if (itemDominio == null) {
			throw new RuntimeException("Não foi possível localizar o item de domínio para o label: "+labelItem+", e de domínio: "+(dominio != null ? dominio.getLabel() : null));
		}
		return itemDominio;
	}

	public ItemDominio findItemDominio(String label, Dominio dominio) {
		if (dominio == null) {
			throw new RuntimeException("Não é possível consultar 'Item de Domínio' pois a identificação do 'Domínio' está vazia.");
		}
		if (label == null) {
			throw new RuntimeException("Não é possível consultar 'Item de Domínio' pois o label está vazio.");
		}
		return findByLabelAndCodigoDominio(label, dominio.getId());
	}

	public ItemDominio findByLabelAndCodigoDominio(String label, Long idDominio) {
		if (label == null || label.isEmpty() || idDominio == null) {
			throw new ApplicationRuntimeException("Na pesquisa de itens de domínio, os campos label e domínio são obrigatórios");
		}
		return getRepository().findByLabelAndCodigoDominio(label, idDominio);
	}

	public ItemDominio findByLabelAndCodigoModulo(String label, Long idModulo) {
		if (label == null || label.isEmpty() || idModulo == null) {
			throw new ApplicationRuntimeException("Na pesquisa de itens de domínio, os campos label e módulo são obrigatórios");
		}
		return getRepository().findByLabelAndCodigoModulo(label, idModulo);
	}
	
}