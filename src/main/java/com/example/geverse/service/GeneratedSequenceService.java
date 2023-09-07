package com.example.geverse.service;

import com.example.geverse.entity.GeneratedSequence;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GeneratedSequenceService {

    private com.example.geverse.repository.GeneratedSequenceService repository;

    public GeneratedSequenceService(com.example.geverse.repository.GeneratedSequenceService repository) {
        this.repository = repository;
    }

    public GeneratedSequence findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public GeneratedSequence saveGenerated(GeneratedSequence sequence){
        return repository.save(sequence);
    }

}
