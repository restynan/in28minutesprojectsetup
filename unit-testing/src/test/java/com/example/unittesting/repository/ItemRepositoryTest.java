package com.example.unittesting.repository;

import com.example.unittesting.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll(){
      List<Item>items= itemRepository.findAll();
        assertEquals(4,items.size());
    }
}
