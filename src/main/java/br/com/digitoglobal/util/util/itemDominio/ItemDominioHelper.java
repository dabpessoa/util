package br.com.digitoglobal.util.util.itemDominio;

<<<<<<< HEAD
import br.com.digitoglobal.util.bean.model.Dominio;
=======
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
import br.com.digitoglobal.util.bean.model.ItemDominio;
import me.dabpessoa.framework.service.SpringContextProvider;

public class ItemDominioHelper implements IItemDominio {

    private ItemDominio itemDominio;
    private String label;
    private Long codigo;
<<<<<<< HEAD
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
=======
    private String nomeDominio;
    private String nomeModulo;
    private SpringContextProvider springContextProvider;

    public ItemDominioHelper(String label, String nomeDominio, String nomeModulo, SpringContextProvider springContextProvider) {
        this(null, null, label, nomeDominio, nomeModulo, springContextProvider);
    }

    public ItemDominioHelper(Long codigo, String label, SpringContextProvider springContextProvider) {
        this(null, codigo, label, null, null, springContextProvider);
    }

    public ItemDominioHelper(ItemDominio itemDominio, Long codigo, String label, String nomeDominio, String nomeModulo, SpringContextProvider springContextProvider) {
        this.itemDominio = itemDominio;
        this.codigo = codigo;
        this.label = label;
        this.nomeDominio = nomeDominio;
        this.nomeModulo = nomeModulo;
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
        this.springContextProvider = springContextProvider;
    }

    @Override
    public ItemDominio getItem(boolean deveBuscarDoBancoDeDados) {
<<<<<<< HEAD
        return getItem(null, deveBuscarDoBancoDeDados);
    }

    @Override
    public ItemDominio getItem(Dominio dominio) {
        return getItem(dominio, true);
=======
        if ((itemDominio == null || itemDominio.getId() == null) && deveBuscarDoBancoDeDados) {
            preencherItemAPartirDoBancoDeDados();
        }
        return itemDominio;
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
    }

    @Override
    public ItemDominio getItem() {
<<<<<<< HEAD
        return getItem(null,true);
    }

    @Override
    public ItemDominio getItem(Dominio dominio, boolean deveBuscarDoBancoDeDados) {
        if ((itemDominio == null || itemDominio.getId() == null) && deveBuscarDoBancoDeDados) {
            if (dominio == null) dominio = this.dominio;
            itemDominio = buscarItemAPartirDoBancoDeDados(label, dominio, springContextProvider);
        }
        return itemDominio;
=======
        return getItem(true);
    }

    @Override
    public void preencherItemAPartirDoBancoDeDados() {
        itemDominio = buscarNoBancoDeDados(this.label, this.nomeDominio, this.nomeModulo, springContextProvider);
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
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

<<<<<<< HEAD
    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
=======
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
>>>>>>> b9bf6d3f4d65d8df0ea17e0c174b740a829104cc
    }

}
