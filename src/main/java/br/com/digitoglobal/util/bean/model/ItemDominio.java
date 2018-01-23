package br.com.digitoglobal.util.bean.model;

import me.dabpessoa.framework.dao.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_dominio" , schema = "util")
public class ItemDominio  extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="label")
    private String label;

    @Column(name="descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="fk_dominio", referencedColumnName="id")
    private Dominio dominio;

    public ItemDominio() {
        this(null, null, null);
    }

    public ItemDominio(String label, String descricao, Dominio dominio) {
        this.label = label;
        this.descricao = descricao;
        this.dominio = dominio;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ItemDominio that = (ItemDominio) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        return dominio != null ? dominio.equals(that.dominio) : that.dominio == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (dominio != null ? dominio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemDominio{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dominio=" + dominio +
                '}';
    }

}
