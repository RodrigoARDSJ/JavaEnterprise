package br.com.fiap.nano.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_produto", nullable = false)
    private int id;

    @Column(name = "nm_produto", nullable = false, length = 25)
    private String nome;

    @Column(name = "vl_produto", nullable = false)
    private double preco;

    @Column(name = "dt_produto")
    @Temporal(TemporalType.DATE)
    private Calendar dataValidade;

    @Column(name = "ds_produto", length = 200)
    private String descricao;

    @Column(name = "ds_estado_produto")
    @Enumerated(EnumType.STRING)
    private EstadoProduto estado;

    @CreationTimestamp
    @Column(name = "dt_cadastro")
    private Calendar cadastro;

    @UpdateTimestamp
    @Column(name = "dt_modificacao")
    private Calendar modificacao;

    @Formula("vl_produto*0.9")
    private double desconto;

    public Produto() {

    }

    public Produto(int id, String nome, double preco, Calendar dataValidade, String descricao, EstadoProduto estado) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.estado = estado;
    }

    public Produto(String nome, double preco, Calendar dataValidade, String descricao, EstadoProduto estado) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.estado = estado;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Calendar getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EstadoProduto getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoProduto estado) {
        this.estado = estado;
    }
}
