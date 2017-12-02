package br.com.digitoglobal.util.dao;

import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.util.MapFactory;
import me.dabpessoa.framework.dao.GenericAbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDominioDao extends GenericAbstractDao<ItemDominio, Long> {

	public ItemDominio findByLabelAndDominioAndModulo(String label, String nomeDominio, String nomeModulo) {
		return getDaoHelper()
				.queryHQLSingleResult("findByLabelAndDominioAndModulo",
						MapFactory.create("label", label, "nomeDominio", nomeDominio, "nomeModulo", nomeDominio));
	}

}
