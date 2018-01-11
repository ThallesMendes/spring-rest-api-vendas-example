package com.smn.apivendas.services;

import com.smn.apivendas.models.Venda;

import java.util.List;

/**
 * Interface VendaService
 * 09/01/2018
 */
public interface VendaService {

    /**
     * Lista todas as vendas realizadas
     * @return
     */
    public List<Venda> findAll();

    /**
     * Consulta venda por id
     * @param id
     * @return
     */
    public Venda find(Long id);

    /**
     * Cria venda com base em entidade
     * @param venda
     * @return
     */
    public Venda create(Venda venda);

    /**
     * Atuaiza venda por id com base em entidade
     * @param id
     * @param venda
     * @return
     */
    public Venda update(Long id, Venda venda);

    /**
     * Deleta venda por id
     * @param id
     */
    public void delete( Long id );

}
