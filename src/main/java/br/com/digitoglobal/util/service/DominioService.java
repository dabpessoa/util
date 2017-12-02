package br.com.digitoglobal.util.service;

import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.dao.DominioDao;
import br.com.digitoglobal.util.util.SpringContextProviderUtils;
import me.dabpessoa.framework.service.GenericAbstractService;
import org.springframework.stereotype.Service;

@Service
public class DominioService extends GenericAbstractService<Dominio, Long, DominioDao, SpringContextProviderUtils> {


	
}