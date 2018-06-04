package br.com.digitoglobal.util.service;

import br.com.digitoglobal.accesscontrol.model.Modulo;
import br.com.digitoglobal.accesscontrol.service.ModuloService;
import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.dao.DominioDao;
import me.dabpessoa.framework.exceptions.ApplicationRuntimeException;

import me.dabpessoa.framework.service.GenericAbstractService;
import me.dabpessoa.framework.service.SpringContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DominioService extends GenericAbstractService<Dominio, Long, DominioDao, SpringContextProvider> {

    @Autowired ModuloService moduloService;

    @Override
    public List<Dominio> find(Dominio entity) {
        return findByHQLEntityFilter(entity, "descricao");
    }

    public Dominio findDominio(String labelModulo, String labelDominio) {
        Modulo modulo = moduloService.findByLabel(labelModulo);
        return findDominio(modulo, labelDominio);
    }

    public Dominio findDominio(Modulo modulo, String labelDominio) {
        if (modulo == null || modulo.getId() == null) {
            throw new RuntimeException("Não é possível consultar um Domínio pois a identificação do múdulo está vazia. Label do Domínio: "+labelDominio);
        }

        Dominio dominio = findByLabelAndCodigoModulo(labelDominio, modulo.getId());

        if (dominio == null) {
            throw new RuntimeException("O label '"+labelDominio+"' não existe na tabela de domínios no banco de dados. Favor adicioná-lo.");
        }

        return dominio;
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