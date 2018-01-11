package com.smn.apivendas.repositories;

import com.smn.apivendas.models.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Class VendaRepository
 * 09/01/2018
 */
@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
}
