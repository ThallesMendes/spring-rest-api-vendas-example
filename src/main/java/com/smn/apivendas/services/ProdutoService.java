package com.smn.apivendas.services;

import com.smn.apivendas.models.Produto;

import java.util.List;

/**
 * Interface ProdutoService
 * 09/01/2018
 */
public interface ProdutoService {

    /**
     * Lista todos produtos cadastrados
     * @return
     */
    public List<Produto> findAll();

    /**
     * Consulra produto por id
     * @param id
     * @return
     */
    public Produto find( Long id );

    /**
     * Cria produto com base em entidade
     * @param produto
     * @return
     */
    public Produto create(Produto produto);

    /**
     * Atualiza produto por id com base em entidade
     * @param id
     * @param produto
     * @return
     */
    public Produto update(Long id, Produto produto);

    /**
     * Deleta produto por id
     * @param id
     */
    public void delete(Long id);

}
