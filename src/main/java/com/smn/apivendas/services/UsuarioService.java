package com.smn.apivendas.services;

import com.smn.apivendas.models.Usuario;

import java.util.List;

/**
 * Interface UsuarioService
 * 11/01/2018
 */
public interface UsuarioService {

    /**
     * Lista todos os usuários cadastrados
     * @return
     */
    public List<Usuario> findAll();

    /**
     * Consulta usuario por id
     * @param id
     * @return
     */
    public Usuario find( Long id );

    /**
     * Cria usuario com base em entidade
     * @param usuario
     * @return
     */
    public Usuario create( Usuario usuario );

    /**
     * Atualiza usuario por id com base em entidade
     * @param id
     * @param usuario
     * @return
     */
    public Usuario update( Long id, Usuario usuario );

    /**
     * Exclui usuario por id
     * @param id
     */
    public void delete( Long id );
}
