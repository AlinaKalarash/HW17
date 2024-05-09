package com.example.HW16.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "note")
@Data
public class Note {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

}
