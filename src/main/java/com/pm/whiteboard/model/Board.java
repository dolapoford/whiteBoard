package com.pm.whiteboard.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false , unique = true)
    private String boardId;

    @Column(nullable = false )
    private String name;

    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedDate;


    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();

    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
