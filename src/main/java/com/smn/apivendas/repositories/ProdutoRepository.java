package com.smn.apivendas.repositories;

import com.smn.apivendas.models.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface ProdutoRepository
 * 09/01/2018
 */
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
