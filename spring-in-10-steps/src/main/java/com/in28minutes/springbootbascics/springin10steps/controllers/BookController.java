package com.in28minutes.springbootbascics.springin10steps.controllers;

import com.in28minutes.springbootbascics.springin10steps.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {


    @GetMapping("/Books")
    public List<Book> retrieveBook(){
        return  Arrays.asList(new Book(10L,"Mastering spring 5.66","Ranga"));
    }


}
