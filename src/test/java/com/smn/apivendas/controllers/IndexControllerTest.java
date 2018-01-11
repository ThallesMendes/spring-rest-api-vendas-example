package com.smn.apivendas.controllers;

import com.smn.apivendas.ApiVendasApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexControllerTest extends ApiVendasApplicationTests{

    private MockMvc mockMvc;

    @Autowired
    private IndexController indexController;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testGETIndexController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}