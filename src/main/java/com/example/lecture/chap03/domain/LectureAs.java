package com.example.lecture.chap03.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;

@Entity
@Table(name = "LECTURE")
public class LectureAs {

    @Id
    private Long id;

    @Column(name = "lec_name", length = 50)
    private String lectureName;

    private int studentCount;


    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifedDate;

    @Lob
    private String description;

    @Transient
    private String name;
}
