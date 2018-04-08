package br.com.digitoglobal.util.dao;

import br.com.digitoglobal.util.bean.model.ItemDominio;
import br.com.digitoglobal.util.util.MapFactory;
import me.dabpessoa.framework.dao.GenericAbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDominioDao extends GenericAbstractDao<ItemDominio, Long> {

	public ItemDominio findByLabelAndCodigoDominio(String label, Long idDominio) {
		return getDaoHelper()
				.queryHQLSingleResult("from ItemDominio id where id.label = :label and id.dominio.id = :idDominio",
						MapFactory.create("label", label, "idDominio", idDominio));
	}

	public ItemDominio findByLabelAndCodigoModulo(String label, Long idModulo) {
		return getDaoHelper()
				.queryHQLSingleResult("from ItemDominio id join id.dominio d join d.modulo m where id.label = :label and m.id = :idModulo",
						MapFactory.create("label", label, "idModulo", idModulo));
	}

	public ItemDominio findByLabelAndDominioAndModulo(String label, String nomeDominio, String nomeModulo) {
		return getDaoHelper()
				.queryHQLSingleResult("findByLabelAndDominioAndModulo",
						MapFactory.create("label", label, "nomeDominio", nomeDominio, "nomeModulo", nomeDominio));
	}

}
