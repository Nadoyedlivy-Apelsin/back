package com.geverse.controller.messaging;

import com.geverse.service.producer.MQProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MQController.BASE_URL)
public class MQController {
    static final String BASE_URL = "api.geverse.ru/";
    private MQProducer producer;

    public MQController(MQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/create")
    public void sendSequence(@RequestHeader String header){
        producer.pushRequestToQueue(header);
    }

}
