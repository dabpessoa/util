package br.com.digitoglobal.util.util.itemDominio;

import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.bean.model.ItemDominio;
import me.dabpessoa.framework.service.SpringContextProvider;

public class ItemDominioHelper implements IItemDominio {

    private ItemDominio itemDominio;
    private String label;
    private Long codigo;
    private Dominio dominio;
    private SpringContextProvider springContextProvider;

    public ItemDominioHelper(String label, SpringContextProvider springContextProvider) {
        this(null, null, label, null, springContextProvider);
    }

    public ItemDominioHelper(String label, Dominio dominio, SpringContextProvider springContextProvider) {
        this(null, null, label, dominio, springContextProvider);
    }

    public ItemDominioHelper(Long codigo, String label, SpringContextProvider springContextProvider) {
        this(null, codigo, label, null, springContextProvider);
    }

    public ItemDominioHelper(ItemDominio itemDominio, Long codigo, String label, Dominio dominio, SpringContextProvider springContextProvider) {
        this.itemDominio = itemDominio;
        this.codigo = codigo;
        this.label = label;
        this.dominio = dominio;
        this.springContextProvider = springContextProvider;
    }

    @Override
    public ItemDominio getItem(boolean deveBuscarDoBancoDeDados) {
        return getItem(null, deveBuscarDoBancoDeDados);
    }

    @Override
    public ItemDominio getItem(Dominio dominio) {
        return getItem(dominio, true);
    }

    @Override
    public ItemDominio getItem() {
        return getItem(null,true);
    }

    @Override
    public ItemDominio getItem(Dominio dominio, boolean deveBuscarDoBancoDeDados) {
        if ((itemDominio == null || itemDominio.getId() == null) && deveBuscarDoBancoDeDados) {
            if (dominio == null) dominio = this.dominio;
            itemDominio = buscarItemAPartirDoBancoDeDados(label, dominio, springContextProvider);
        }
        return itemDominio;
    }

    public ItemDominio getItemDominio() {
        return itemDominio;
    }

    public void setItemDominio(ItemDominio itemDominio) {
        this.itemDominio = itemDominio;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

}
