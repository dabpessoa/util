package br.com.digitoglobal.util.service;

import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.dao.DominioDao;
import me.dabpessoa.framework.service.GenericAbstractService;
import me.dabpessoa.framework.service.SpringContextProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DominioService extends GenericAbstractService<Dominio, Long, DominioDao, SpringContextProvider> {

    @Override
    public List<Dominio> find(Dominio entity) {
        return findByHQLEntityFilter(entity, "descricao");
    }

}