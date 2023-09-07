package com.example.geverse.controller.messaging;

import com.example.geverse.service.producer.MQProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(MessageController.BASE_URL)
public class MessageController {
    static final String BASE_URL = "main";
    private MQProducer producer;

    public MessageController(MQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/")
    public String sendSequence(@RequestParam("specie") String specieName){
        producer.pushSpecieToQueue(specieName);
        return "redirect:";
    }
}
