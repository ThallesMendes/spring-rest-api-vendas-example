package com.smn.apivendas.services;

import com.smn.apivendas.models.Produto;
import com.smn.apivendas.models.Usuario;
import com.smn.apivendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl( UsuarioRepository usuarioRepository ){
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Lista todos os usuários cadastrados
     *
     * @return
     */
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    /**
     * Consulta usuario por id
     *
     * @param id
     * @return
     */
    @Override
    public Usuario find(Long id) {
        return usuarioRepository.findOne(id);
    }

    /**
     * Cria usuario com base em entidade
     *
     * @param usuario
     * @return
     */
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza usuario por id com base em entidade
     *
     * @param id
     * @param usuario
     * @return
     */
    @Override
    public Usuario update(Long id, Usuario usuario) {

        Usuario usuarioExists = usuarioRepository.findOne(id);

        if(usuarioExists != null){
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }

        return null;
    }

    /**
     * Exclui usuario por id
     *
     * @param id
     */
    @Override
    public void delete(Long id) {

        Usuario usuarioExists = usuarioRepository.findOne(id);

        if(usuarioExists != null){
            usuarioRepository.delete(usuarioExists);
        }

    }
}
