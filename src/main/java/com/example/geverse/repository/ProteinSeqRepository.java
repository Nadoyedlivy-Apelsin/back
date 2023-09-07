package com.example.geverse.repository;

import com.example.geverse.entity.ProteinSeq;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProteinSeqRepository  {
    public Optional<ProteinSeq> findById(Object o) {
        return Optional.empty();
    }

}
