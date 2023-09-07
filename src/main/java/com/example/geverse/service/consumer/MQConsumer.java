package com.example.geverse.service.consumer;


import com.example.geverse.entity.PrepSequence;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MQConsumer {
    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html

    private String restUrl = "https://shtoto";
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(PrepSequence sequence){
        
    }
}
