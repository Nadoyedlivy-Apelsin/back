package com.example.geverse.repository;

import com.example.geverse.entity.PrepSequence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PrepSequenceRepository extends CrudRepository<PrepSequence, Long> {
    @Query("select coalesce(max(id), 0) from PrepSequence ")
    Long getMaxIdFromPrep();

}
