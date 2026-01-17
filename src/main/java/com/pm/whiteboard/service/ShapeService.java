package com.pm.whiteboard.service;

import com.pm.whiteboard.dto.CreateShapeRequest;
import com.pm.whiteboard.model.Shape;
import com.pm.whiteboard.repository.ShapeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShapeService {

    private final ShapeRepository shapeRepository;
    private final BoardService boardService;

    @Transactional
    public Shape createShape(CreateShapeRequest createShapeRequest){
        boardService.getBoardById(createShapeRequest.getBoardId());

        Shape shape = new Shape();
        shape.setBoardId(createShapeRequest.getBoardId());
        shape.setType(createShapeRequest.getType());
        shape.setX(createShapeRequest.getX());
        shape.setY(createShapeRequest.getY());
        shape.setWidth(createShapeRequest.getWidth());
        shape.setHeight(createShapeRequest.getHeight());
        shape.setColor(createShapeRequest.getColor());
        Shape savedShape = shapeRepository.save(shape);
        log.info("Shape created with id: {}", shape.getId());
        return savedShape;
    }

    public List<Shape> getShapesByBoardId(String boardId){
        return shapeRepository.findByBoardIdOrderByCreatedAtAsc(boardId);
    }

    @Transactional
    public Shape updateShape(Long id, CreateShapeRequest request) {
        Shape shape = getShapeById(id);
        shape.setX(request.getX());
        shape.setY(request.getY());
        shape.setWidth(request.getWidth());
        shape.setHeight(request.getHeight());
        shape.setColor(request.getColor());
        shape.setRotation(request.getRotation());
        shape.setText(request.getText());
        return shapeRepository.save(shape);
    }

    @Transactional
    public void deleteShape(Long id) {
        Shape shape = getShapeById(id);
        shapeRepository.delete(shape);
        log.info("Deleted shape {}", id);
    }

    @Transactional
    public void deleteAllShapesOnBoard(String boardId) {
        shapeRepository.deleteByBoardId(boardId);
        log.info("Deleted all shapes from board {}", boardId);
    }

    public Shape getShapeById(Long id) {
        return shapeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found: " + id));
    }

    public long countShapesOnBoard(String boardId) {
        return shapeRepository.countByBoardId(boardId);
    }


}
