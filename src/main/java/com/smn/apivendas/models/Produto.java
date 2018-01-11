package com.smn.apivendas.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String descricao;

    @Column(nullable = false, precision = 15, scale = 2)
    private Double preco_venda;

    @Column(nullable = false, precision = 15, scale = 3)
    private Double estoque;

    @Column(nullable = false)
    private Boolean status;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId" )
    private Set<VendaItem> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
