package com.smn.apivendas.controllers;

import com.smn.apivendas.contracts.ApiError;
import com.smn.apivendas.models.Produto;
import com.smn.apivendas.services.ProdutoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Produtos")
@ApiResponses(@ApiResponse(code=500, message = "Erro interno", response = ApiError.class))
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtoService){
        this.produtoService = produtoService;
    }

    @ApiOperation("Lista todos os produtos")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @ApiOperation("Consulta produto por id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Produto find( @PathVariable(value = "id") Long id ){
        return produtoService.find(id);
    }

    @ApiOperation("Insere produto")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto create( @RequestBody Produto produto ){
        return produtoService.create(produto);
    }

    @ApiOperation("Atualiza produto por id")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Produto update( @PathVariable(value = "id") Long id, @RequestBody Produto produto ){
        return produtoService.update(id, produto);
    }

    @ApiOperation("Deleta produto por id")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete( @PathVariable(value = "id") Long id ){
        produtoService.delete(id);
    }
}
