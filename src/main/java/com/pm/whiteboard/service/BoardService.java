package com.pm.whiteboard.service;

import com.pm.whiteboard.dto.CreateBoardRequest;
import com.pm.whiteboard.model.Board;
import com.pm.whiteboard.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public Board createBoard(CreateBoardRequest request) {
        Board board = new Board();
        board.setBoardId(generateBoardId());
        board.setName(request.getName());
        board.setDescription(request.getDescription());

        Board savedBoard = boardRepository.save(board);
        log.info("Created board: {}", savedBoard.getBoardId());
        return savedBoard;
    }

    public Board getBoardById(String boardId){
        return  boardRepository.findByBoardId(boardId).orElseThrow(()-> new RuntimeException("Board not found"));
    }

    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    @Transactional
    public Board updateBoard(String boardId, CreateBoardRequest request) {
        Board board = getBoardById(boardId);
        board.setName(request.getName());
        board.setDescription(request.getDescription());
        Board updatedBoard = boardRepository.save(board);
        log.info("Updated board: {}", updatedBoard.getBoardId());
        return updatedBoard;
    }

    @Transactional
    public void deleteBoard(String boardId) {
        Board board = getBoardById(boardId);
        boardRepository.delete(board);
        log.info("Deleted board: {}", boardId);
    }




    public String generateBoardId(){
        return "board-" + UUID.randomUUID().toString().substring(0,8);
    }
}
