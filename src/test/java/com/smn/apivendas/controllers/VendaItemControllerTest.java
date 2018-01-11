package com.smn.apivendas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.interceptors.VendaItemVerifyInterceptor;
import com.smn.apivendas.models.Produto;
import com.smn.apivendas.models.Venda;
import com.smn.apivendas.models.VendaItem;
import com.smn.apivendas.services.ProdutoServiceImpl;
import com.smn.apivendas.services.VendaItemService;
import com.smn.apivendas.services.VendaItemServiceImpl;
import com.smn.apivendas.services.VendaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
public class VendaItemControllerTest extends ApiVendasApplicationTests {

    private MockMvc mockMvc;
    private Venda venda;
    private Produto produto;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private VendaItemController vendaItemController;

    @Autowired
    private VendaItemServiceImpl vendaItemService;

    @Autowired
    private VendaServiceImpl vendaService;

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Before
    public void setUp(){

        this.venda = new Venda();
        venda.setValor_bruto(400.00);
        venda.setValor_desconto(0.00);
        venda.setValor_total(400.00);
        venda.setStatus(1);
        venda.setData_finalizado(new Date());

        vendaService.create(venda);

        this.produto = new Produto();
        produto.setDescricao("PRODUTO TESTE VENDA ITEM");
        produto.setEstoque(0.0);
        produto.setPreco_venda(10.0);
        produto.setStatus(true);

        produtoService.create(produto);

        VendaItem vendaItem = new VendaItem();
        vendaItem.setProdutoId(produto);
        vendaItem.setVendaId(venda);
        vendaItem.setQuantidade(1.0);
        vendaItem.setQuantidade_devolvido(0.0);
        vendaItem.setValor_total(10.0);
        vendaItem.setValor_unitario(10.0);
        vendaItem.setValor_desconto(0.0);
        vendaItem.setDevolvido(false);

        vendaItemService.create(vendaItem);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


    }

    @Test
    public void findByVenda() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/vendas/" + venda.getId().toString() + "/itens")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void find() throws Exception{

        List<VendaItem> list = vendaItemService.findByVenda(venda);
        VendaItem vendaItem = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/vendas/" + venda.getId().toString() + "/itens/" + vendaItem.getId().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void create() throws Exception{

        VendaItem vendaItem = new VendaItem();
        vendaItem.setProdutoId(produto);
        vendaItem.setVendaId(venda);
        vendaItem.setQuantidade(2.0);
        vendaItem.setQuantidade_devolvido(0.0);
        vendaItem.setValor_total(20.0);
        vendaItem.setValor_unitario(10.0);
        vendaItem.setValor_desconto(0.0);
        vendaItem.setDevolvido(false);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(vendaItem);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/vendas/" + venda.getId().toString() + "/itens/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception{
        List<VendaItem> list = vendaItemService.findByVenda(venda);
        VendaItem vendaItem = list.get(list.size() - 1);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(vendaItem);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/vendas/" + venda.getId().toString() + "/itens/" + vendaItem.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void delete() throws Exception {
        List<VendaItem> list = vendaItemService.findByVenda(venda);
        VendaItem vendaItem = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/vendas/" + venda.getId().toString() + "/itens/" + vendaItem.getId().toString()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void vendaNotFound() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/vendas/0/itens"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}