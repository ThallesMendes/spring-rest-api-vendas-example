package com.smn.apivendas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.models.Produto;
import com.smn.apivendas.services.ProdutoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProdutoControllerTest extends ApiVendasApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private ProdutoController produtoController;

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Before
    public void setUp(){

        Produto produto = new Produto();
        produto.setDescricao("PRODUTO TESTE");
        produto.setPreco_venda(0.00);
        produto.setEstoque(0.00);
        produto.setStatus(true);

        produtoService.create(produto);

        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @Test
    public void findAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/produtos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void find() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/produtos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void create() throws Exception {

        Produto produto = new Produto();
        produto.setDescricao("KINECT XBOX");
        produto.setPreco_venda(45.00);
        produto.setEstoque(5.0);
        produto.setStatus(true);

        ObjectMapper mapper = new ObjectMapper();


        this.mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(produto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void update() throws Exception {

        List<Produto> list = produtoService.findAll();
        Produto produto = list.get(list.size() - 1);
        produto.setDescricao("PRODUTO ATUALIZADO");

        ObjectMapper mapper = new ObjectMapper();

        this.mockMvc.perform(MockMvcRequestBuilders.put("/produtos/" + produto.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(produto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete() throws Exception {

        List<Produto> list = produtoService.findAll();
        Produto produto = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/produtos/" + produto.getId().toString())).andExpect(MockMvcResultMatchers.status().isNoContent());

    }
}