package br.com.digitoglobal.util.service;

import br.com.digitoglobal.accesscontrol.model.Modulo;
import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.dao.DominioDao;
import me.dabpessoa.framework.exceptions.ApplicationRuntimeException;

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

    public Dominio findByLabelAndCodigoModulo(String label, Long idModulo) {
        if (label == null || label.isEmpty() || idModulo == null) {
            throw new ApplicationRuntimeException("Na pesquisa de um Domínio, os campos label e módulo são obrigatórios");
        }
        return getRepository().findByLabelAndCodigoModulo(label, idModulo);
    }

    public List<Dominio> findDominiosByModulo(Modulo modulo) {
        if (modulo == null || modulo.getId() == null) {
            throw new ApplicationRuntimeException("Módulo vazio na pesquisa de domínios.");
        }
        return find(new Dominio(modulo));
    }

}