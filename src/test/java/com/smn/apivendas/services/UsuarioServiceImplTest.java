package com.smn.apivendas.services;

import com.smn.apivendas.ApiVendasApplicationTests;
import com.smn.apivendas.models.Usuario;
import com.smn.apivendas.repositories.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static  org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioServiceImplTest extends ApiVendasApplicationTests {

    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private Usuario usuario;

    @Mock
    private List<Usuario> usuarioList;

    @Before
    public void setUpMocks(){
        MockitoAnnotations.initMocks(this);
        usuarioService = new UsuarioServiceImpl(usuarioRepository);
    }

    @Test
    public void findAll() {
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        List<Usuario> listRetrieved = usuarioService.findAll();
        assertThat(listRetrieved, is(equalTo(usuarioList)));
    }

    @Test
    public void find() {
        when(usuarioRepository.findOne((long)1)).thenReturn(usuario);
        Usuario usuarioRetrieved = usuarioService.find((long)1);
        assertThat(usuarioRetrieved, is(equalTo(usuario)));
    }

    @Test
    public void create() {
        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioCreated = usuarioService.create(usuario);
        assertThat(usuarioCreated, is(equalTo(usuario)));
    }

    @Test
    public void update() {
        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        when(usuarioRepository.findOne((long)1)).thenReturn(usuario);

        Usuario usuarioUpdated = usuarioService.update((long)1, usuario);
        assertThat(usuarioUpdated, is(equalTo(usuario)));
    }

    @Test
    public void delete() {
        doNothing().when(usuarioRepository).delete(usuario);
        when(usuarioRepository.findOne((long)1)).thenReturn(usuario);

        usuarioService.delete((long)1);

        verify(usuarioRepository, times(1)).delete(usuario);
    }
}