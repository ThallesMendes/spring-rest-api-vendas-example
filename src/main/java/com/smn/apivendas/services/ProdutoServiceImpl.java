package com.smn.apivendas.services;

import com.smn.apivendas.models.Produto;
import com.smn.apivendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Class ProdutoServiceImpl
 * 09/01/2018
 */
@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl( ProdutoRepository produtoRepository ){
        this.produtoRepository = produtoRepository;
    }

    /**
     * Lista todos produtos cadastrados
     *
     * @return
     */
    @Override
    public List<Produto> findAll() {
        return (List<Produto>) produtoRepository.findAll();
    }

    /**
     * Consulra produto por id
     *
     * @param id
     * @return
     */
    @Override
    public Produto find(Long id) {
        return produtoRepository.findOne(id);
    }

    /**
     * Cria produto com base em entidade
     *
     * @param produto
     * @return
     */
    @Override
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Atualiza produto por id com base em entidade
     *
     * @param id
     * @param produto
     * @return
     */
    @Override
    public Produto update(Long id, Produto produto) {
        Produto produtoExists = produtoRepository.findOne(id);

        if(produtoExists != null){
            produto.setId(id);
            return produtoRepository.save(produto);
        }

        return null;
    }

    /**
     * Deleta produto por id
     *
     * @param id
     */
    @Override
    public void delete(Long id) {

        Produto produtoExists = produtoRepository.findOne(id);

        if(produtoExists != null){
            produtoRepository.delete(produtoExists);
        }

    }
}
