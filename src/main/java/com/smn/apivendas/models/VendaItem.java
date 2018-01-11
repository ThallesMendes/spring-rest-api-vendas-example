package com.smn.apivendas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.smn.apivendas.serializers.VendaItemDeserialize;

import javax.persistence.*;

@Entity
@Table(name = "venda_item")
@JsonDeserialize(using = VendaItemDeserialize.class)
public class VendaItem implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 15, scale = 2)
    private Double valor_unitario;

    @Column(nullable = false, precision = 15, scale = 3)
    private Double quantidade;

    @Column(precision = 15, scale = 3)
    private Double quantidade_devolvido;

    @Column(precision = 15, scale = 2)
    private Double valor_desconto;

    @Column(nullable = false, precision = 15, scale = 2)
    private Double valor_total;

    @Column
    private Boolean devolvido;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "venda_id")
    //@JsonBackReference
    private Venda vendaId;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produtoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getQuantidade_devolvido() {
        return quantidade_devolvido;
    }

    public void setQuantidade_devolvido(Double quantidade_devolvido) {
        this.quantidade_devolvido = quantidade_devolvido;
    }

    public Double getValor_desconto() {
        return valor_desconto;
    }

    public void setValor_desconto(Double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

}
