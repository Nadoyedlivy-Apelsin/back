package com.geverse.repository;

import com.geverse.entity.PrepSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PrepSequenceRepository extends JpaRepository<PrepSequence, Long> {
    @Query("select coalesce(max(id), 0) from PrepSequence")
    Long getMaxIdFromPrep();

    @Query("select p from PrepSequence p where p.header = ?1")
    PrepSequence findPrepSequenceByHeader(String header);

}
