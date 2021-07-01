package br.com.fiap.nano.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "TB_FORNECEDOR")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_fornecedor", nullable = false)
    private int id;

    @Column(name = "nm_fornecedor", nullable = false, length = 50)
    private String nome;

    @Column(name = "dt_cadastro")
    @CreationTimestamp
    private Calendar dataCadastro;

    @Column(name = "dt_modificacao")
    @UpdateTimestamp
    private Calendar dataModificacao;

    public Fornecedor() {

    }

    public Fornecedor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Fornecedor(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
