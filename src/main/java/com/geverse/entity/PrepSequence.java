package com.geverse.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(schema = "seq_database", name = "prep_sequence")
public class PrepSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String header;

    @Column
    private String sequence;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
