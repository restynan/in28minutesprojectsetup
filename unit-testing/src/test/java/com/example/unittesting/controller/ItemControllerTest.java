package com.example.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    MockMvc mockMvc;

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


}
