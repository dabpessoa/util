package br.com.digitoglobal.util.dao;

import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.util.MapFactory;
import me.dabpessoa.framework.dao.GenericAbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class DominioDao extends GenericAbstractDao<Dominio, Long> {

	public Dominio findByLabelAndCodigoModulo(String label, Long idModulo) {
        return getDaoHelper()
                .queryHQLSingleResult("from Dominio d where d.label = :label and d.modulo.id = :idModulo"
                                        ,MapFactory.create("label", label, "idModulo", idModulo));
    }

}
