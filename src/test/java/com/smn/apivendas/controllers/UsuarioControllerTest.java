package com.smn.apivendas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.models.Usuario;
import com.smn.apivendas.models.embedded.Endereco;
import com.smn.apivendas.models.embedded.Nome;
import com.smn.apivendas.services.UsuarioServiceImpl;
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

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UsuarioControllerTest extends ApiVendasApplicationTests {

    private MockMvc mockMvc;
    private String email;
    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Before
    public void setUp(){

        this.mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        Nome nome = new Nome("Thalles", "Mendes");
        Endereco endereco = new Endereco("Rua Marcelo Lima Sanches", "2210", null, "Tropical 2", "Franca", "SP");

        email = UUID.randomUUID().toString();

        Usuario usuario = new Usuario(nome, email + "@gmail.com", endereco);

        usuarioService.create(usuario);
    }

    @Test
    public void findAll() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/usuarios")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void find() throws Exception{
        List<Usuario> list = usuarioService.findAll();
        Usuario usuario = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/" + usuario.getId().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void create() throws Exception {

        email = UUID.randomUUID().toString();

        Nome nome = new Nome("Teste", "Create");
        Endereco endereco = new Endereco("Rua Marcelo Lima Sanches", "2210", null, "Tropical 2", "Franca", "SP");
        Usuario usuario = new Usuario(nome,  email +"@gmail.com", endereco);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/usuarios/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void update() throws Exception{

        email = UUID.randomUUID().toString();

        List<Usuario> list = usuarioService.findAll();
        Usuario usuario = list.get(list.size() - 1);
        usuario.setEmail( email +"@atualizado.com.br");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/usuarios/" + usuario.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void delete() throws Exception {
        List<Usuario> list = usuarioService.findAll();
        Usuario usuario = list.get(list.size() - 1);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/" + usuario.getId().toString())).andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}