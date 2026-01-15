package com.pm.whiteboard.dto;

import com.pm.whiteboard.model.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardResponse {
    private Long id;
    private String boardId;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardResponse from(Board board) {
        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setId(board.getId());
        boardResponse.setBoardId(board.getBoardId());
        boardResponse.setName(board.getName());
        boardResponse.setDescription(board.getDescription());
        boardResponse.setCreatedAt(LocalDateTime.now());
        boardResponse.setUpdatedAt(LocalDateTime.now());
        return boardResponse;
    }
}
