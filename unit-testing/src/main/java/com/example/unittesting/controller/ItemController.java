package com.example.unittesting.controller;

import com.example.unittesting.domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/item")
    public Item retrieveItem(){
        return new Item (1,"Ball",10 ,100);

    }
}
