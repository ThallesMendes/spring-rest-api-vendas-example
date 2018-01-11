package com.smn.apivendas.repositories;

import com.smn.apivendas.models.Venda;
import com.smn.apivendas.models.VendaItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class VendaItemRepository
 */
@Repository
public interface VendaItemRepository extends CrudRepository<VendaItem, Long> {

    List<VendaItem> findByVendaId(Venda vendaId);
}
