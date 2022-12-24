package com.example.aliarslan.basickafkademo.tasks;

import com.example.aliarslan.basickafkademo.model.KafkaMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.function.Supplier;

@AllArgsConstructor
@Slf4j
public class Iwork {
    private KafkaMessage kafkaMessage;

    public KafkaMessage emulationWork() throws InterruptedException {
        Supplier<Integer> timeSleepRandom = () -> new Random().nextInt(2000);
        int timeSleep = timeSleepRandom.get();
        Thread.sleep(timeSleep);
        log.info("Message received. MessageID : {} Message: {} Date : {} I worked time: {}ms I thread: {}",
                kafkaMessage.getId(), kafkaMessage.getMessage(), kafkaMessage.getMessageDate(), timeSleep, Thread.currentThread().getName());
        return kafkaMessage;
    }
}
