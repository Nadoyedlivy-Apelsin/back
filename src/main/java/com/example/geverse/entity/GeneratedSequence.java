package com.example.geverse.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table()
public class GeneratedSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gen_sequence_id")
    private Long id;

    @Column
    private String sequence;

    @CollectionTable(name = "gen_sequence_properties",
                    joinColumns = @JoinColumn(name = "gen_sequence_id"),
                     uniqueConstraints = @UniqueConstraint(columnNames = {"gen_sequence_id", "properties"}))
    @ElementCollection(fetch = FetchType.LAZY)
    @JoinColumn
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
