package com.geverse.controller.messaging;

import com.geverse.service.producer.MQProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(MQController.BASE_URL)
public class MQController {
    static final String BASE_URL = "geverse.ru/";
    private MQProducer producer;

    public MQController(MQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/")
    public String sendSequence(){
        producer.pushRequestToQueue();
        return "redirect:";
    }
}
