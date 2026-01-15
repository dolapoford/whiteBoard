package com.pm.whiteboard.repository;

import com.pm.whiteboard.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

    Optional<UserSession> findBySessionId(String sessionId);

    List<UserSession> findByBoardId(String boardId);

    void deleteBySessionId(String sessionId);

    // Find inactive sessions (not active in last 5 minutes)
    List<UserSession> findByLastActiveBefore(LocalDateTime timestamp);
}
