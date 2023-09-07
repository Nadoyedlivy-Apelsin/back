package com.example.geverse.service.consumer;


import com.example.geverse.entity.GeneratedSequence;
import com.example.geverse.entity.PrepSequence;
import com.example.geverse.repository.GeneratedSequenceService;
import com.example.geverse.util.ObjectMapperUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class MQConsumer {
    private final String targetUrl = "https://shtoto";
    private ObjectMapperUtil objectMapperUtil;
    private GeneratedSequenceService service;

    @Autowired
    public MQConsumer(ObjectMapperUtil objectMapperUtil, GeneratedSequenceService service) {
        this.objectMapperUtil = objectMapperUtil;
        this.service = service;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(PrepSequence sequence) {
        String requestBody = objectMapperUtil.convertSequenceToJSON(sequence);
        String responseBody;
        try {
            responseBody = formRequest(requestBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (responseBody != null){
             GeneratedSequence generatedSequence = objectMapperUtil.convertJSONToSequence(responseBody);
             service.save(generatedSequence);
        }
    }

    private String formRequest(String requestBody) throws IOException {
        URL url = new URL(targetUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(requestBody);
        }

        String response = new String();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = bf.readLine()) != null) {
                response = line;
            }
        }

        return response;
    }


}
