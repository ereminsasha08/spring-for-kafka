package com.example.aliarslan.basickafkademo.model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "message", "messageDate"})
public class KafkaMessage {

    public KafkaMessage(String message) {
        this.message = message;
    }
    private String message;
    private String id = UUID.randomUUID().toString();
    private LocalDate messageDate = LocalDate.now();
}
