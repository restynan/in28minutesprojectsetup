package com.example.libraryeventproducer.producer;

import com.example.libraryeventproducer.domain.LibraryEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class LibraryEventProducer {
    String topic = "libraryEvent";
    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public void sendLibraryEvent(LibraryEvent libraryEvent) throws JsonProcessingException {
        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);

        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.sendDefault(key, value);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);

            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);

            }
        });


    }


    public void sendLibraryEventApproach2(LibraryEvent libraryEvent) throws JsonProcessingException {
        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);

        ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, topic);

        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);

            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);

            }
        });


    }

    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
        List<Header> recordHeader = List.of(new RecordHeader("event-source", "scanner".getBytes()));

        return new ProducerRecord<>(topic, null, key, value, recordHeader);
    }


    public SendResult<Integer, String> sendLibraryEventSynchronous(LibraryEvent libraryEvent) throws JsonProcessingException, TimeoutException {
        Integer key = libraryEvent.getLibraryEventId();
        SendResult<Integer, String> sendResult = null;
        String value = objectMapper.writeValueAsString(libraryEvent);
        try {
            sendResult = kafkaTemplate.sendDefault(key, value).get(1, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException e) {
            log.error("ExecutionException | InterruptedException handling message and exception is {}", e.getMessage());
        } catch (Exception e) {
            log.error("Exception  handling message and exception is {}", e.getMessage());
            throw e;
        }

        return sendResult;
    }


    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("error handling message and exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("error in failure : {}", throwable.getMessage());
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message sent successfully for the key : {}, value : {}, and partition: {}", key, value, result.getRecordMetadata().partition());

    }

}
