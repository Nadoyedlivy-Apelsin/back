package com.example.geverse.service.producer;

import com.example.geverse.entity.ProteinSeq;
import com.example.geverse.repository.ProteinSeqRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MQProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    RabbitTemplate template;
    ProteinSeqRepository repository;

    public MQProducer(RabbitTemplate template, ProteinSeqRepository repository) {
        this.template = template;
        this.repository = repository;
    }

    public void pushSpecieToQueue(String specie) {
        //go to repository and get entity
        //then push it to the queue
        if (specie.equals("Citrus")) {
            Optional<ProteinSeq> sequence = repository.findById(1L);
            template.convertAndSend(routingKey, exchange, sequence);
        }
    }




}
