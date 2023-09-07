package com.example.geverse.service.producer;

import com.example.geverse.entity.PrepSequence;
import com.example.geverse.service.PrepSequenceService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class MQProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    private final RabbitTemplate template;
    private final PrepSequenceService service;

    @Autowired
    public MQProducer(RabbitTemplate template, PrepSequenceService service) {
        this.template = template;
        this.service = service;
    }

    public void pushRequestToQueue() {
        Long maxId = service.getMaxIdFromPrep();
        int randomId = ThreadLocalRandom.current().nextInt(1, Math.toIntExact(maxId + 1));
        PrepSequence sequence = service.findById(Long.valueOf(randomId));
        template.convertAndSend(routingKey, exchange, sequence);
    }


}
