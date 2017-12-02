package br.com.digitoglobal.util.util.itemDominio;

import br.com.digitoglobal.util.bean.model.ItemDominio;

public class ItemDominioHelper implements IItemDominio {

    private ItemDominio itemDominio;
    private String label;
    private Long codigo;
    private String nomeDominio;
    private String nomeModulo;

    public ItemDominioHelper(String label, String nomeDominio, String nomeModulo) {
        this(null, null, label, nomeDominio, nomeModulo);
    }

    public ItemDominioHelper(Long codigo, String label) {
        this(null, codigo, label, null, null);
    }

    public ItemDominioHelper(ItemDominio itemDominio, Long codigo, String label, String nomeDominio, String nomeModulo) {
        this.itemDominio = itemDominio;
        this.codigo = codigo;
        this.label = label;
        this.nomeDominio = nomeDominio;
        this.nomeModulo = nomeModulo;
    }

    @Override
    public ItemDominio getItem(boolean deveBuscarDoBancoDeDados) {
        if ((itemDominio == null || itemDominio.getId() == null) && deveBuscarDoBancoDeDados) {
            preencherItemAPartirDoBancoDeDados();
        }
        return itemDominio;
    }

    @Override
    public ItemDominio getItem() {
        return getItem(true);
    }

    @Override
    public void preencherItemAPartirDoBancoDeDados() {
        itemDominio = buscarNoBancoDeDados(this.label, this.nomeDominio, this.nomeModulo);
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

    public String getNomeDominio() {
        return nomeDominio;
    }

    public void setNomeDominio(String nomeDominio) {
        this.nomeDominio = nomeDominio;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

}
