package br.com.digitoglobal.util.service;

import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.dao.ItemDominioDao;
import me.dabpessoa.framework.exceptions.ApplicationRuntimeException;
import me.dabpessoa.framework.service.GenericAbstractService;
import me.dabpessoa.framework.service.SpringContextProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDominioService extends GenericAbstractService<ItemDominio, Long, ItemDominioDao, SpringContextProvider> {

	@Override
	public List<ItemDominio> find(ItemDominio entity) {
		return findByHQLEntityFilter(entity, "descricao");
	}

	public ItemDominio findByLabelAndDominioAndModulo(String label, String nomeDominio, String nomeModulo) {
		if (label == null || label.isEmpty() || nomeDominio == null || nomeDominio.isEmpty() || nomeModulo == null || nomeModulo.isEmpty()) {
			throw new ApplicationRuntimeException("Na pesquisa de itens de domínio, os campos label, nome do domínio e nome do módulo devem estar preenchidos. Valores => label: "+label+", Nome do Domínio: "+nomeDominio+", Nome do Módulo: "+nomeModulo);
		}
		return getRepository().findByLabelAndDominioAndModulo(label, nomeDominio, nomeModulo);
	}
	
}