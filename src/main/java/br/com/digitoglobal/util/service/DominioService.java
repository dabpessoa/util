package br.com.digitoglobal.util.service;

import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.dao.DominioDao;
<<<<<<< HEAD
import me.dabpessoa.framework.exceptions.ApplicationRuntimeException;
=======
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
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

<<<<<<< HEAD
    public Dominio findByLabelAndCodigoModulo(String label, Long idModulo) {
        if (label == null || label.isEmpty() || idModulo == null) {
            throw new ApplicationRuntimeException("Na pesquisa de um Domínio, os campos label e módulo são obrigatórios");
        }
        return getRepository().findByLabelAndCodigoModulo(label, idModulo);
    }

=======
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
}