package com.pm.whiteboard.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sessionId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String color;

    private String boardId;

    @Column(name = "last_active")
    private LocalDateTime lastActive;

    @Column(name = "connected_at")
    private LocalDateTime connectedAt;

    @PrePersist
    protected void onCreate() {
        connectedAt = LocalDateTime.now();
        lastActive = LocalDateTime.now();
    }
}
