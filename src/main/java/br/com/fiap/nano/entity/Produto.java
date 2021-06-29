package br.com.fiap.nano.entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_produto", nullable = false)
    private Long id;

    @Column(name = "nm_produto", nullable = false, length = 25)
    private String nome;

    @Column(name = "vl_produto", nullable = false)
    private BigDecimal preco;

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
    private BigDecimal desconto;

    public Produto() {}

    public Produto(Long id, String nome, BigDecimal preco, Calendar dataValidade, String descricao, EstadoProduto estado, Calendar cadastro, Calendar modificacao, BigDecimal desconto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.estado = estado;
        this.cadastro = cadastro;
        this.modificacao = modificacao;
        this.desconto = desconto;
    }

    public Produto(String nome, BigDecimal preco, Calendar dataValidade, String descricao, EstadoProduto estado, Calendar cadastro, Calendar modificacao, BigDecimal desconto) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.estado = estado;
        this.cadastro = cadastro;
        this.modificacao = modificacao;
        this.desconto = desconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EstadoProduto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProduto estado) {
        this.estado = estado;
    }
}
