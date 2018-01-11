package com.smn.apivendas.controllers;

import com.smn.apivendas.contracts.ApiError;
import com.smn.apivendas.models.Venda;
import com.smn.apivendas.services.VendaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Vendas")
@ApiResponses(@ApiResponse(code=500, message = "Erro interno", response = ApiError.class))
@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaServiceImpl vendaService;

    public VendaController(VendaServiceImpl vendaService){
        this.vendaService = vendaService;
    }

    @ApiOperation("Lista todas as vendas")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Venda> findAll(){
        return vendaService.findAll();
    }

    @ApiOperation("Consulta venda por id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Venda find( @PathVariable(value = "id") Long id ){
        return vendaService.find(id);
    }

    @ApiOperation("Insere venda")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Venda create( @RequestBody Venda venda){
        return vendaService.create(venda);
    }

    @ApiOperation("Atualiza venda por id")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Venda update( @PathVariable(value = "id") Long id, @RequestBody Venda venda ){
        return vendaService.update(id, venda);
    }

    @ApiOperation("Deleta venda por id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable(value = "id") Long id ){
        vendaService.delete(id);
    }



}
