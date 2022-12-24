package com.example.aliarslan.basickafkademo.service;

import com.example.aliarslan.basickafkademo.model.KafkaMessage;
import com.example.aliarslan.basickafkademo.tasks.Iwork;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@Slf4j
public class KafkaConsumerService {

    public ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public List<Future<KafkaMessage>> futures = new ArrayList<>();
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}")
    public void listen(@Payload KafkaMessage kafkaMessage) {
        futures.add(
                CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                return new Iwork(kafkaMessage).emulationWork();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        threadPool
                ));
    }
}
