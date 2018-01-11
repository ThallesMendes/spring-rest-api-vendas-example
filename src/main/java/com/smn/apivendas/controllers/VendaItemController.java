package com.smn.apivendas.controllers;

import com.smn.apivendas.contracts.ApiError;
import com.smn.apivendas.models.Venda;
import com.smn.apivendas.models.VendaItem;
import com.smn.apivendas.services.ProdutoServiceImpl;
import com.smn.apivendas.services.VendaItemServiceImpl;
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

@Api("Venda Itens")
@ApiResponses(@ApiResponse(code=500, message = "Erro interno", response = ApiError.class))
@RestController
@RequestMapping("/vendas/{id}/itens")
public class VendaItemController {

    @Autowired
    private VendaServiceImpl vendaService;

    @Autowired
    private VendaItemServiceImpl vendaItemService;

    @Autowired
    private ProdutoServiceImpl produtoService;

    @ApiOperation("Lista todos os itens de uma venda")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<VendaItem> findByVenda( @PathVariable(value = "id") Long id ){
        Venda venda = vendaService.find(id);

        if(venda != null){
            return vendaItemService.findByVenda(venda);
        }
        return null;
    }

    @ApiOperation("Consulta item por id")
    @GetMapping(value = "/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public VendaItem find( @PathVariable(value = "itemId") Long id ){
        return vendaItemService.find(id);
    }

    @ApiOperation("Insere item em venda")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public VendaItem create(@PathVariable(value = "id") Long id, @RequestBody VendaItem vendaItem){
        Venda venda = vendaService.find(id);


        if(venda != null){
            vendaItem.setVendaId(venda);
            return vendaItemService.create(vendaItem);
        }

        return null;
    }

    @ApiOperation("Atualiza item de venda por id")
    @PutMapping(value = "/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public VendaItem update( @PathVariable(value = "itemId") Long itemId, @RequestBody VendaItem vendaItem ){
        VendaItem itemExists = vendaItemService.find(itemId);

        if(itemExists != null){
            vendaItem.setId(itemId);
            return vendaItemService.update(itemId, vendaItem);
        }

        return null;
    }

    @ApiOperation("Deleta item de venda")
    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable(value = "itemId") Long itemId ){
        VendaItem itemExists = vendaItemService.find(itemId);

        if(itemExists != null){
            vendaItemService.delete(itemId);
        }
    }






}
