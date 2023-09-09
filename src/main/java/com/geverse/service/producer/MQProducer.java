package com.geverse.service.producer;

import com.geverse.entity.PrepSequence;
import com.geverse.service.PrepSequenceService;
import com.geverse.util.ObjectMapperUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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

    public void pushRequestToQueue(String header) {
//        Long maxId = service.getMaxIdFromPrep();
//        int randomId = ThreadLocalRandom.current().nextInt(1, Math.toIntExact(maxId + 1));
//        PrepSequence sequence = service.findById(Long.valueOf(randomId));
        PrepSequence sequence = service.findPrepSequenceByHeader(header);
        template.convertAndSend(routingKey, exchange, sequence);
    }


}
