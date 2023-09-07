package com.example.geverse.service.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MQConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(){

    }
}
