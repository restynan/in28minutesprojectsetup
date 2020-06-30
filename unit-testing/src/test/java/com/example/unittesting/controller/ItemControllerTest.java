package com.example.unittesting.controller;

import com.example.unittesting.domain.Item;
import com.example.unittesting.repository.BusinessRepository;
import com.example.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// only load services related to itemController , it will  not load the services related the itembusinessService
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ItemBusinessService itemBusinessService;

    @Test
    public void item_basic() throws Exception {
        //call "/helloworld" application Json

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quatity\":100}"))
                .andReturn();

        //verify helloworld
        // assertEquals("Hello world",result.getResponse().getContentAsString());




    }
    @Test
    public void itemfromBusinessService_basic() throws Exception {

        when(itemBusinessService.retrieveHardCodedItem()).thenReturn(new Item (2,"pen",20 ,2200));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:pen,price:20,quatity:2200}"))
                .andReturn();


    }

    @Test
    public void retrieveAllItemFromDatabase_basic() throws Exception {


        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(1001,"book",89,123)
                        ,new Item(1002,"clipboard",90,423)
                        , new Item(1003,"pencils",35,600)
                ,new Item(1004,"reams",78,459))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result= mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1001,name:book,price:89,quatity:123},{id:1002,name:clipboard,price:90,quatity:423},{id:1003,name:pencils,price:35,quatity:600},{id:1004,name:reams,price:78,quatity:459}]"))
                .andReturn();


    }


}
