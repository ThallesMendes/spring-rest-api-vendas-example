package com.smn.apivendas.services;

import com.smn.apivendas.models.Venda;
import com.smn.apivendas.models.VendaItem;
import com.smn.apivendas.repositories.VendaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Class VendaItemServiceImpl
 * 09/01/2018
 */
@Service
@Transactional
public class VendaItemServiceImpl implements VendaItemService {

    @Autowired
    private VendaItemRepository vendaItemRepository;

    public VendaItemServiceImpl(VendaItemRepository vendaItemRepository){
        this.vendaItemRepository = vendaItemRepository;
    }

    /**
     * Lista todos os itens de uma venda realizada
     *
     * @param vendaId
     * @return
     */
    @Override
    public List<VendaItem> findByVenda(Venda vendaId) {
        return vendaItemRepository.findByVendaId(vendaId);
    }

    /**
     * Consulta item por id
     *
     * @param id
     * @return
     */
    @Override
    public VendaItem find(Long id) {
        return vendaItemRepository.findOne(id);
    }

    /**
     * Cria item com base em uma entidade
     *
     * @param vendaItem
     * @return
     */
    @Override
    public VendaItem create(VendaItem vendaItem) {
        return vendaItemRepository.save(vendaItem);
    }

    /**
     * Atualiza item por id com base em uma entidade
     *
     * @param id
     * @param vendaItem
     * @return
     */
    @Override
    public VendaItem update(Long id, VendaItem vendaItem) {
        VendaItem itemExists = vendaItemRepository.findOne(id);

        if(itemExists != null){
            vendaItem.setId(id);
            return vendaItemRepository.save(vendaItem);
        }

        return null;
    }

    /**
     * Deleta item por id
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        VendaItem itemExists = vendaItemRepository.findOne(id);

        if(itemExists != null){
            vendaItemRepository.delete(itemExists);
        }
    }
}
