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

	public ItemDominio findByLabelAndDominioAndModulo(String label, String nomeDominio, String nomeModulo) {
		if (label == null || label.isEmpty() || nomeDominio == null || nomeDominio.isEmpty() || nomeModulo == null || nomeModulo.isEmpty()) {
			throw new ApplicationRuntimeException("Na pesquisa de itens de domínio, os campos label, nome do domínio e nome do módulo devem estar preenchidos. Valores => label: "+label+", Nome do Domínio: "+nomeDominio+", Nome do Módulo: "+nomeModulo);
		}
		return getRepository().findByLabelAndDominioAndModulo(label, nomeDominio, nomeModulo);
	}
	
}