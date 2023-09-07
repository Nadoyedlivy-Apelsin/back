package com.example.geverse.service;

import com.example.geverse.entity.GeneratedSequence;
import com.example.geverse.repository.GeneratedSequenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GeneratedSequenceService {

    private GeneratedSequenceRepository repository;

    public GeneratedSequenceService(GeneratedSequenceRepository repository) {
        this.repository = repository;
    }

    public GeneratedSequence findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public GeneratedSequence saveGenerated(GeneratedSequence sequence){
        return repository.save(sequence);
    }

}
