package br.com.digitoglobal.util.service;

import br.com.digitoglobal.util.bean.model.Pessoa;
import br.com.digitoglobal.util.dao.PessoaDao;
import me.dabpessoa.framework.service.GenericAbstractService;
import me.dabpessoa.framework.service.SpringContextProvider;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dabpessoa [dabpessoa@gmail.com] on 13/02/2017.
 */
@Service
public class PessoaService extends GenericAbstractService<Pessoa, Long, PessoaDao, SpringContextProvider> {

    @Override
    public List<Pessoa> find(Pessoa entity) {
        return findByHQLEntityFilter(entity, "nome");
    }

}
