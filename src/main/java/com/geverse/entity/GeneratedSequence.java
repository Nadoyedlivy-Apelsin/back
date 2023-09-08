package com.geverse.entity;

import jakarta.persistence.*;

import java.util.List;

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
    private List<String> properties = List.of();

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

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }
}
