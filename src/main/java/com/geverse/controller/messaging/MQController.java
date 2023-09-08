package com.geverse.controller.messaging;

import com.geverse.entity.PrepSequence;
import com.geverse.service.producer.MQProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(MQController.BASE_URL)
public class MQController {
    static final String BASE_URL = "http://api.gen.geverse.ru/";
    private MQProducer producer;

    public MQController(MQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/create")
    public void sendSequence(){
        producer.pushRequestToQueue();
    }


}
