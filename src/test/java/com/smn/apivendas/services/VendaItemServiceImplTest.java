package com.smn.apivendas.services;

import com.smn.apivendas.models.Venda;
import com.smn.apivendas.models.VendaItem;
import com.smn.apivendas.repositories.VendaItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendaItemServiceImplTest {

    private VendaItemServiceImpl vendaItemService;

    @Mock
    private VendaItemRepository vendaItemRepository;
    @Mock
    private Venda venda;
    @Mock
    private VendaItem vendaItem;
    @Mock
    private List<VendaItem> vendaItemList;

    @Before
    public void setupMocks(){
        MockitoAnnotations.initMocks(this);
        vendaItemService = new VendaItemServiceImpl(vendaItemRepository);
    }

    @Test
    public void findByVenda() {
        when(vendaItemRepository.findByVendaId(venda)).thenReturn(vendaItemList);
        List<VendaItem> listRetrieved = vendaItemService.findByVenda(venda);
        assertThat(listRetrieved, is(equalTo(vendaItemList)));
    }

    @Test
    public void find() {
        when(vendaItemRepository.findOne((long)1)).thenReturn(vendaItem);
        VendaItem vendaItemRetrieved = vendaItemService.find((long)1);
        assertThat(vendaItemRetrieved, is(equalTo(vendaItem)));
    }

    @Test
    public void create() {
        when(vendaItemRepository.save(vendaItem)).thenReturn(vendaItem);
        VendaItem vendaItemCreated = vendaItemService.create(vendaItem);
        assertThat(vendaItemCreated, is(equalTo(vendaItem)));
    }

    @Test
    public void update() {
        when(vendaItemRepository.save(vendaItem)).thenReturn(vendaItem);
        when(vendaItemRepository.findOne((long)1)).thenReturn(vendaItem);

        VendaItem vendaItemUpdated = vendaItemService.update((long)1, vendaItem);
        assertThat(vendaItemUpdated, is(equalTo(vendaItem)));
    }

    @Test
    public void delete() {
        when(vendaItemRepository.findOne((long)1)).thenReturn(vendaItem);
        doNothing().when(vendaItemRepository).delete(vendaItem);

        vendaItemService.delete((long)1);

        verify(vendaItemRepository, times(1)).delete(vendaItem);
    }
}