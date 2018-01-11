package com.smn.apivendas.controllers;

import com.smn.apivendas.models.Usuario;
import com.smn.apivendas.services.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    public UsuarioController( UsuarioServiceImpl usuarioService ){
        this.usuarioService = usuarioService;
    }

    @ApiOperation("Lista todos os usuários")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @ApiOperation("Consulta usuario por id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Usuario find(@PathVariable(value = "id") Long id){
        return usuarioService.find(id);
    }

    @ApiOperation("Insere usuario")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create( @RequestBody Usuario usuario ){
        return usuarioService.create(usuario);
    }

    @ApiOperation("Atualiza usuario por id")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Usuario update( @PathVariable(value = "id") Long id, @RequestBody Usuario usuario ){
        return usuarioService.update(id, usuario);
    }

    @ApiOperation("Deleta usuario por id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable(value = "id") Long id ){
        usuarioService.delete(id);
    }



}
