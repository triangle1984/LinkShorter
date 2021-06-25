package com.example.linkshorter.infrastructure.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class ShortUrlEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String urlToShort;
    @Column(unique = true)
    private String prefix;
}
