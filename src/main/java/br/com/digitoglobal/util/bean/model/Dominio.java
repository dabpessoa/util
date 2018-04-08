package br.com.digitoglobal.util.bean.model;

import me.dabpessoa.framework.dao.BaseEntity;
import br.com.digitoglobal.accesscontrol.model.Modulo;

import javax.persistence.*;

@Entity
@Table(name = "dominio" , schema = "util")
public class Dominio  extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_modulo", referencedColumnName = "id")
    private Modulo modulo;

    @Column(name="label")
    private String label;

    @Column(name="descricao")
    private String descricao;

    public Dominio() {
        this(null, null, null);
    }

    public Dominio(Modulo modulo) {
        this(modulo, null);
    }

    public Dominio(Modulo modulo, String label) {
        this(modulo, label, null);
    }

    public Dominio(Modulo modulo, String label, String descricao) {
        this.modulo = modulo;
        this.label = label;
        this.descricao = descricao;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dominio dominio = (Dominio) o;

        if (id != null ? !id.equals(dominio.id) : dominio.id != null) return false;
        if (modulo != null ? !modulo.equals(dominio.modulo) : dominio.modulo != null) return false;
        return label != null ? label.equals(dominio.label) : dominio.label == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (modulo != null ? modulo.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dominio{" +
                "id=" + id +
                ", modulo=" + modulo +
                ", label='" + label + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

}
