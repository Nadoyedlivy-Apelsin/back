package com.example.geverse.service;

import com.example.geverse.entity.PrepSequence;
import com.example.geverse.repository.PrepSequenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PrepSequenceService {
    private PrepSequenceRepository repository;

    @Autowired
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
