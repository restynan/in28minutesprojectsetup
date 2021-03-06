package com.example.kafka.springkafkaconsumer.listener;

import com.example.kafka.springkafkaconsumer.models.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "kafka-Example", groupId ="group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }


/*@KafkaListener(topics = "Kafka_Example", group = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }



    @KafkaListener(topics = "final-topic", groupId = "group_one", containerFactory = "kafkaListenerContainerFactory")
public void consumeUserMessage(@Payload Container msg, @Headers MessageHeaders headers) throws IOException {
    System.out.println("received data in Consumer One ="+ msg.getMessageTypes());
}
*/


}