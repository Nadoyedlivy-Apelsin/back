package com.geverse.service;

import com.geverse.entity.PrepSequence;
import com.geverse.repository.PrepSequenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PrepSequenceService {
    private final PrepSequenceRepository repository;

    public PrepSequenceService(PrepSequenceRepository repository) {
        this.repository = repository;
    }

    public PrepSequence findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PrepSequence savePrepairedSequence(PrepSequence sequence){
        return repository.save(sequence);
    }

    public Long getMaxIdFromPrep(){
        return repository.getMaxIdFromPrep();
    }



}
