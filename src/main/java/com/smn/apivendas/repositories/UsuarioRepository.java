package com.smn.apivendas.repositories;

import com.smn.apivendas.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
