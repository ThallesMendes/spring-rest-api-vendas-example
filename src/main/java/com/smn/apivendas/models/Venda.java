package com.smn.apivendas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "venda")
public class Venda implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 15, scale = 2)
    private Double valor_bruto;

    @Column(precision = 15, scale = 2)
    private Double valor_desconto;

    @Column(nullable = false, precision = 15, scale = 2)
    private Double valor_total;

    @Column(nullable = false, precision = 15, scale = 2)
    private Date data_finalizado;

    @Column(nullable = false)
    private Integer status;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaId")
    private Set<VendaItem> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(Double valor_bruto) {
        this.valor_bruto = valor_bruto;
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

    public Date getData_finalizado() {
        return data_finalizado;
    }

    public void setData_finalizado(Date data_finalizado) {
        this.data_finalizado = data_finalizado;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<VendaItem> getItens() {
        return itens;
    }

    public void setItens(Set<VendaItem> itens) {
        this.itens = itens;
    }
}
