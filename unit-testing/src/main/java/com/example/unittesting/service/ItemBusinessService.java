package com.example.unittesting.service;

import com.example.unittesting.domain.Item;
import com.example.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {
    @Autowired
    private ItemRepository itemRepository;


    public Item retrieveHardCodedItem() {
        return new Item(2, "pen", 20, 2200);
    }

    public Item retrieveItem(int id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> retrieveAllItems() {

        List<Item>items=itemRepository.findAll();

        for(Item item:items){
            item.setValue(item.getPrice()*item.getQuatity());
        }
        return items;
    }


}
