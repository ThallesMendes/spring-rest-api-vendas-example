package com.smn.apivendas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.models.Venda;
import com.smn.apivendas.services.VendaServiceImpl;
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


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class VendaControllerTest extends ApiVendasApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private VendaController vendaController;

    @Autowired
    private VendaServiceImpl vendaService;

    @Before
    public void setUp(){

        Venda venda = new Venda();
        venda.setValor_bruto(400.00);
        venda.setValor_desconto(0.00);
        venda.setValor_total(400.00);
        venda.setStatus(1);
        venda.setData_finalizado(new Date());

        vendaService.create(venda);

        this.mockMvc = MockMvcBuilders.standaloneSetup(vendaController).build();
    }

    @Test
    public void findAll() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/vendas")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void find() throws Exception{
        List<Venda> list = vendaService.findAll();
        Venda venda = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/vendas/" + venda.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void create() throws Exception {

        Venda venda = new Venda();
        venda.setValor_bruto(400.00);
        venda.setValor_desconto(0.00);
        venda.setValor_total(400.00);
        venda.setStatus(1);
        venda.setData_finalizado(new Date());

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(venda);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/vendas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void update() throws Exception{

        List<Venda> list = vendaService.findAll();
        Venda venda = list.get(list.size() - 1);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(venda);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/vendas/" + venda.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void delete() throws Exception {
        List<Venda> list = vendaService.findAll();
        Venda venda = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/vendas/" + venda.getId().toString())).andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}