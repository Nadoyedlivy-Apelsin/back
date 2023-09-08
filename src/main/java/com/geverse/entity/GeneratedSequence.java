package com.geverse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;

import java.util.Set;

@Entity
@Table(schema = "seq_database", name = "generated_sequence")
public class GeneratedSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gen_sequence_id")
    private Long id;

    @Column
    private String sequence;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<String> properties = Set.of();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Set<String> getProperties() {
        return properties;
    }

    public void setProperties(Set<String> properties) {
        this.properties = properties;
    }
}
