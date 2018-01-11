package com.smn.apivendas.services;

import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.models.Venda;
import com.smn.apivendas.repositories.VendaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VendaServiceImplTest extends ApiVendasApplicationTests{

    private VendaServiceImpl vendaService;

    @Mock
    private VendaRepository vendaRepository;
    @Mock
    private Venda venda;
    @Mock
    private List<Venda> vendaList;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        vendaService = new VendaServiceImpl(vendaRepository);
    }

    @Test
    public void findAll() {
        when(vendaRepository.findAll()).thenReturn(vendaList);
        List<Venda> listRetrieved = vendaService.findAll();
        assertThat(listRetrieved, is(equalTo(vendaList)));
    }

    @Test
    public void find() {
        when(vendaRepository.findOne((long)1)).thenReturn(venda);
        Venda vendaRetrieved = vendaService.find((long)1);
        assertThat(vendaRetrieved, is(equalTo(venda)));
    }

    @Test
    public void create() {
        when(vendaRepository.save(venda)).thenReturn(venda);
        Venda vendaCreated = vendaService.create(venda);
        assertThat(vendaCreated, is(equalTo(venda)));
    }

    @Test
    public void update() {
        when(vendaRepository.save(venda)).thenReturn(venda);
        when(vendaRepository.findOne((long)1)).thenReturn(venda);
        Venda vendaFind = vendaRepository.findOne((long)1);
        Venda vendaUpdated = vendaService.update((long)1, venda);
        assertThat(vendaUpdated, is(equalTo(venda)));
    }

    @Test
    public void delete() {
        when(vendaRepository.findOne((long)1)).thenReturn(venda);
        doNothing().when(vendaRepository).delete(venda);

        vendaService.delete((long)1);

        verify(vendaRepository, times(1)).delete(venda);
    }
}