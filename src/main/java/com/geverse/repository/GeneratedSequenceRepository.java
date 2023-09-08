package com.geverse.repository;

import com.geverse.entity.GeneratedSequence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface GeneratedSequenceRepository extends CrudRepository<GeneratedSequence, Long> {
    @Query("select coalesce(max(id), 0) from GeneratedSequence ")
    Long getMaxIdFromGenerated();
}
