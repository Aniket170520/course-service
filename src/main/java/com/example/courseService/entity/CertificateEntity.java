package com.example.courseService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "certificates")
public class CertificateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certId;

    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    private LocalDate issueDate = LocalDate.now();
}

