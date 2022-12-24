package com.example.aliarslan.basickafkademo.tasks;

import com.example.aliarslan.basickafkademo.model.KafkaMessage;
import com.example.aliarslan.basickafkademo.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;

@Component
@Slf4j
public class SendMessageTask {
    private final KafkaProducerService producer;

    public SendMessageTask(KafkaProducerService producer) {
        this.producer = producer;
    }

    // run every 3 sec
    @Scheduled(fixedRateString = "500")
    public void send() {
        Supplier<Integer> sup = () -> new Random().nextInt(1000000);
        this.producer.sendMessage(new KafkaMessage(sup.get().toString()));

    }
}