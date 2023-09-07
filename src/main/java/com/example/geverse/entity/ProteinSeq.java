package com.example.geverse.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ProteinSeq {
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
}
