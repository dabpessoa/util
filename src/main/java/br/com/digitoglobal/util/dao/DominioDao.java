package br.com.digitoglobal.util.dao;

import br.com.digitoglobal.util.bean.model.Dominio;
<<<<<<< HEAD
import br.com.digitoglobal.util.util.MapFactory;
=======
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
import me.dabpessoa.framework.dao.GenericAbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class DominioDao extends GenericAbstractDao<Dominio, Long> {
	
<<<<<<< HEAD
	public Dominio findByLabelAndCodigoModulo(String label, Long idModulo) {
        return getDaoHelper()
                .queryHQLSingleResult("from Dominio d where d.label = :label and d.modulo.id = :idModulo"
                                        ,MapFactory.create("label", label, "idModulo", idModulo));
    }
=======
	
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc

}
