package com.pm.whiteboard.repository;

import com.pm.whiteboard.model.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {

    List<Shape> findByBoardId(String boardId);

    List<Shape> findByBoardIdOrderByCreatedAtAsc(String boardId);

    void deleteByBoardId(String boardId);

    long countByBoardId(String boardId);
}
