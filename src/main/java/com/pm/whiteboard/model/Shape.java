package com.pm.whiteboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String boardId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double x;

    @Column(nullable = false)
    private Double y;

    private Double width;

    private Double height;

    @Column(nullable = false)
    private String color;

    private Double rotation;

    @Column(length = 1000)
    private String text;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;  // User ID

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (rotation == null) rotation = 0.0;
    }




}
