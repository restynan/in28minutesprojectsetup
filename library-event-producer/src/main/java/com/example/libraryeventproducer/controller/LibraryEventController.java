package com.example.libraryeventproducer.controller;

import com.example.libraryeventproducer.domain.LibraryEvent;
import com.example.libraryeventproducer.domain.LibraryEventType;
import com.example.libraryeventproducer.producer.LibraryEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class LibraryEventController {
    @Autowired
    LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/libraryEvent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException, TimeoutException {
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        //asychronous approach 2
        libraryEventProducer.sendLibraryEventApproach2(libraryEvent);

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }

    }
/*
* log.info("Before executing sendLibraryEvent");
                 //asychronous approach 1
                 //libraryEventProducer.sendLibraryEvent(libraryEvent);
                 *
                 * //sychronous
                 * // SendResult<Integer, String> sendResult= libraryEventProducer.sendLibraryEventSynchronous(libraryEvent);
        //log.info("sendResult : {}",sendResult.toString());

                 log.info("After executing sendLibraryEvent");
*
* */