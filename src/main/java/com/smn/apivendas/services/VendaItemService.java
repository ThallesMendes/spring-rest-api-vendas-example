package com.smn.apivendas.services;

import com.smn.apivendas.models.Venda;
import com.smn.apivendas.models.VendaItem;

import java.util.List;

/**
 * Interface VendaItemService
 * 09/01/2018
 */
public interface VendaItemService {

    /**
     * Lista todos os itens de uma venda realizada
     * @param vendaId
     * @return
     */
    public List<VendaItem> findByVenda(Venda vendaId);

    /**
     * Consulta item por id
     * @param id
     * @return
     */
    public VendaItem find(Long id);

    /**
     * Cria item com base em uma entidade
     * @param vendaItem
     * @return
     */
    public VendaItem create( VendaItem vendaItem );

    /**
     * Atualiza item por id com base em uma entidade
     * @param id
     * @param vendaItem
     * @return
     */
    public VendaItem update(Long id, VendaItem vendaItem);

    /**
     * Deleta item por id
     * @param id
     */
    public void delete(Long id);

}
