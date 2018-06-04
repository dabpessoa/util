package br.com.digitoglobal.util.util.itemDominio;

import br.com.digitoglobal.accesscontrol.model.Modulo;
import br.com.digitoglobal.util.bean.model.Dominio;
import br.com.digitoglobal.util.bean.model.ItemDominio;
import me.dabpessoa.framework.service.SpringContextProvider;

public class ItemDominioHelper implements IItemDominio {

    private ItemDominio itemDominio;
    private Dominio dominio;
    private SpringContextProvider springContextProvider;

    public ItemDominioHelper(String label, String labelDominio, String labelModulo, SpringContextProvider springContextProvider) {
        ItemDominio itemDominio = new ItemDominio();
        itemDominio.setLabel(label);
        itemDominio.setDominio(new Dominio(new Modulo(labelModulo), labelDominio));
        initItemDominioHelper(itemDominio, springContextProvider);
    }

    public ItemDominioHelper(String label, String labelDominio, Modulo modulo, SpringContextProvider springContextProvider) {
        ItemDominio itemDominio = new ItemDominio();
        itemDominio.setLabel(label);
        itemDominio.setDominio(new Dominio(modulo, labelDominio));
        initItemDominioHelper(itemDominio, springContextProvider);
    }

    public ItemDominioHelper(String label, Dominio dominio, SpringContextProvider springContextProvider) {
        ItemDominio itemDominio = new ItemDominio();
        itemDominio.setLabel(label);
        itemDominio.setDominio(dominio);
        initItemDominioHelper(itemDominio, springContextProvider);
    }

    public ItemDominioHelper(Long codigo, String label, SpringContextProvider springContextProvider) {
        ItemDominio itemDominio = new ItemDominio();
        itemDominio.setId(codigo);
        itemDominio.setLabel(label);
        initItemDominioHelper(itemDominio, springContextProvider);
    }

    public ItemDominioHelper(ItemDominio itemDominio, SpringContextProvider springContextProvider) {
        initItemDominioHelper(itemDominio, springContextProvider);
    }

    private void initItemDominioHelper(ItemDominio itemDominio, SpringContextProvider springContextProvider) {
        this.itemDominio = itemDominio;
        this.springContextProvider = springContextProvider;
    }

    @Override
    public ItemDominio getItem() {
        return getItem(true);
    }

    @Override
    public ItemDominio getItem(boolean deveBuscarDoBancoDeDados) {
        if (deveBuscarDoBancoDeDados) {
            fetchItemDominio(null);
        }
        return itemDominio;
    }

    @Override
    public ItemDominio getItem(Dominio dominio) {
        return getItem(dominio, true);
    }

    @Override
    public ItemDominio getItem(Dominio dominio, boolean deveBuscarDoBancoDeDados) {
        if (deveBuscarDoBancoDeDados) {
            fetchItemDominio(dominio);
        }
        return itemDominio;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

    private void fetchDominio() {
        if (dominio == null) {
            Modulo modulo = IItemDominio.findModulo(getLabelModulo(), springContextProvider);
            dominio = IItemDominio.findDominio(modulo, getLabelDominio(), springContextProvider);
        }
    }

    private ItemDominio fetchItemDominio(Dominio dominio) {
        if (!isItemDominioIdsPreenchidos()) {
            if (dominio == null) {
                fetchDominio();
                dominio = this.dominio;
            }

            String labelItem = getLabelItem();
            itemDominio = buscarItemAPartirDoBancoDeDados(labelItem, dominio, springContextProvider);
            if (itemDominio == null) {
                throw new RuntimeException("Não foi possível localizar o item de domínio para o label: "+labelItem+", e de domínio: "+(dominio != null ? dominio.getLabel() : null));
            }
        } return itemDominio;
    }

    private boolean isItemDominioIdsPreenchidos() {
        if (getItemDominio() == null || getItemDominio().getId() == null || getItemDominio().getLabel() == null || getItemDominio().getDominio() == null ||
                getItemDominio().getDominio().getId() == null || getItemDominio().getDominio().getModulo() == null || getItemDominio().getDominio().getModulo().getId() == null) {
            return false;
        } return true;
    }

    private String getLabelItem() {
        if (getItemDominio() != null) {
            return getItemDominio().getLabel();
        } return null;
    }

    private String getLabelModulo() {
        if (getItemDominio() != null && getItemDominio().getDominio() != null && getItemDominio().getDominio().getModulo() != null) {
            return getItemDominio().getDominio().getModulo().getLabel();
        } return null;
    }

    private String getLabelDominio() {
        if (getItemDominio() != null && getItemDominio().getDominio() != null) {
            return getItemDominio().getDominio().getLabel();
        } return null;
    }

    public ItemDominio getItemDominio() {
        return itemDominio;
    }

    public void setItemDominio(ItemDominio itemDominio) {
        this.itemDominio = itemDominio;
    }

}
