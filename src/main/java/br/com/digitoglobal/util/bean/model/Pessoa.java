package br.com.digitoglobal.util.bean.model;

import me.dabpessoa.framework.dao.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa" , schema = "util")
public class Pessoa extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pessoa", referencedColumnName = "id")
    private ItemDominio idTipoPessoa;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id")
    private ItemDominio estadoCivil;

    @ManyToOne
    @JoinColumn(name = "id_pessoa_origem", referencedColumnName = "id")
    private Pessoa idPessoaOrigem;

    @Column(name="nome")
    private String nome;

    @Column(name="nome_social")
    private String nomeSocial;

    @Column(name="email")
    private String email;

    @Column(name="dt_nascimento")
    private Date dataNascimento;

    @Column(name="dt_cadastro")
    private Date dataCadastro;

    public Pessoa() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public Pessoa(Long id) {
        this(id, null, null, null, null, null, null, null, null);
    }

    public Pessoa(Long id, ItemDominio idTipoPessoa, ItemDominio estadoCivil, Pessoa idPessoaOrigem, String nome, String nomeSocial, String email, Date dataNascimento, Date dataCadastro) {
        this.id = id;
        this.idTipoPessoa = idTipoPessoa;
        this.estadoCivil = estadoCivil;
        this.idPessoaOrigem = idPessoaOrigem;
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemDominio getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(ItemDominio idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    public ItemDominio getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(ItemDominio estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Pessoa getIdPessoaOrigem() {
        return idPessoaOrigem;
    }

    public void setIdPessoaOrigem(Pessoa idPessoaOrigem) {
        this.idPessoaOrigem = idPessoaOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pessoa pessoa = (Pessoa) o;

        if (id != null ? !id.equals(pessoa.id) : pessoa.id != null) return false;
        if (idTipoPessoa != null ? !idTipoPessoa.equals(pessoa.idTipoPessoa) : pessoa.idTipoPessoa != null)
            return false;
        if (idPessoaOrigem != null ? !idPessoaOrigem.equals(pessoa.idPessoaOrigem) : pessoa.idPessoaOrigem != null)
            return false;
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        if (nomeSocial != null ? !nomeSocial.equals(pessoa.nomeSocial) : pessoa.nomeSocial != null) return false;
        if (email != null ? !email.equals(pessoa.email) : pessoa.email != null) return false;
        return dataNascimento != null ? dataNascimento.equals(pessoa.dataNascimento) : pessoa.dataNascimento == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (idTipoPessoa != null ? idTipoPessoa.hashCode() : 0);
        result = 31 * result + (idPessoaOrigem != null ? idPessoaOrigem.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (nomeSocial != null ? nomeSocial.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

}
