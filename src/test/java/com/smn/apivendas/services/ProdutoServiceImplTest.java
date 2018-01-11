package com.smn.apivendas.services;

import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.models.Produto;
import com.smn.apivendas.repositories.ProdutoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProdutoServiceImplTest extends ApiVendasApplicationTests {

    private ProdutoServiceImpl produtoService;

    @Mock
    private ProdutoRepository produtoRepository;
    @Mock
    private Produto produto;
    @Mock
    private List<Produto> produtoList;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        produtoService = new ProdutoServiceImpl(produtoRepository);
    }

    @Test
    public void findAll() {
        when(produtoRepository.findAll()).thenReturn(produtoList);
        List<Produto> listRetrieved = produtoService.findAll();
        assertThat(listRetrieved, is(equalTo(produtoList)));
    }

    @Test
    public void find() {
        when(produtoRepository.findOne((long)5)).thenReturn(produto);
        Produto produtoRetrieved = produtoService.find((long)5);
        assertThat(produtoRetrieved, is(equalTo(produto)));
    }

    @Test
    public void create() {
        when(produtoRepository.save(produto)).thenReturn(produto);
        Produto produtoCreated = produtoService.create(produto);
        assertThat(produtoCreated, is(equalTo(produto)));
    }

    @Test
    public void update() {
        when(produtoRepository.save(produto)).thenReturn(produto);
        when(produtoRepository.findOne((long)1)).thenReturn(produto);

        Produto produtoUpdated = produtoService.update((long)1, produto);
        assertThat(produtoUpdated, is(equalTo(produto)));
    }

    @Test
    public void delete() {
        when(produtoRepository.findOne((long)5)).thenReturn(produto);
        doNothing().when(produtoRepository).delete(produto);
        ProdutoRepository my = Mockito.mock(ProdutoRepository.class);

        produtoService.delete((long)5);

        verify(produtoRepository, times(1)).delete(produto);
    }
}