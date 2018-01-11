package com.smn.apivendas.services;

import com.smn.apivendas.models.Venda;
import com.smn.apivendas.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Class VendaServiceImpl
 */
@Service
@Transactional
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaServiceImpl(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    /**
     * Lista todas as vendas realizadas
     *
     * @return
     */
    @Override
    public List<Venda> findAll() {
        return (List<Venda>) vendaRepository.findAll();
    }

    /**
     * Consulta venda por id
     *
     * @param id
     * @return
     */
    @Override
    public Venda find(Long id) {
        return vendaRepository.findOne(id);
    }

    /**
     * Cria venda com base em entidade
     *
     * @param venda
     * @return
     */
    @Override
    public Venda create(Venda venda) {
        return vendaRepository.save(venda);
    }

    /**
     * Atuaiza venda por id com base em entidade
     *
     * @param id
     * @param venda
     * @return
     */
    @Override
    public Venda update(Long id, Venda venda) {
        Venda vendaExists = vendaRepository.findOne(id);

        if (vendaExists != null ){
            venda.setId(id);
            return vendaRepository.save(venda);
        }

        return null;
    }

    /**
     * Deleta venda por id
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        Venda vendaExists = vendaRepository.findOne(id);

        if(vendaExists != null){
            vendaRepository.delete(vendaExists);
        }
    }
}
