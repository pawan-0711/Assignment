package com.assignment.kafka.controller;


import com.assignment.kafka.engine.Producer;
import com.assignment.kafka.model.ParentRecord;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish1", consumes = "application/json")
    public void sendMessageToKafkaTopic(@RequestBody ParentRecord parentRecord) {
        this.producer.sendlog(parentRecord);
    }


}
