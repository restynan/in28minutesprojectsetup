package com.example.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
public class HelloworldControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello_world_basic() throws Exception {
        //call "/helloworld" application Json

        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);


              MvcResult result= mockMvc.perform(request)
                      .andExpect(status().isOk())
                      .andExpect(content().string("Hello world"))
                      .andReturn();

              //verify helloworld
             // assertEquals("Hello world",result.getResponse().getContentAsString());




    }
}
