package com.example.unittesting.service;

import com.example.unittesting.domain.Item;
import com.example.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
//@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemBusinessService itemBusinessService;
@Test
    public void retrieveAllItemsTest(){
    when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1001,"book",10,10)
                                ,new Item(1002,"clipboard",5,5)));
        List<Item>itemss =itemBusinessService.retrieveAllItems();
        System.out.println(itemss);
      assertEquals(100,itemss.get(0).getValue());


    }
}
