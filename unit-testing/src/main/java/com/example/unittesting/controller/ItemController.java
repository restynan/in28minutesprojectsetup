package com.example.unittesting.controller;

import com.example.unittesting.domain.Item;
import com.example.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemBusinessService itemBusinessService;


    @GetMapping("/item")
    public Item retrieveItem() {
        return new Item(1, "Ball", 10, 100);

    }

    @GetMapping("/item-from-business-service")
    public Item retrieveItemFromBusinessService() {
        return itemBusinessService.retrieveHardCodedItem();

    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItemFromDatabase() {
        return itemBusinessService.retrieveAllItems();

    }
}
