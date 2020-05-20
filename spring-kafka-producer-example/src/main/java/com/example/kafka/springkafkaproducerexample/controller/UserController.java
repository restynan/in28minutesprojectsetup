package com.example.kafka.springkafkaproducerexample.controller;

import com.example.kafka.springkafkaproducerexample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
   private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC ="kafka-Example";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody User user){

      kafkaTemplate.send(TOPIC,user);
        return "published successfully";
    }
}
