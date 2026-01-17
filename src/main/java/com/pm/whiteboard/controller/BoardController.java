package com.pm.whiteboard.controller;

import com.pm.whiteboard.dto.BoardResponse;
import com.pm.whiteboard.dto.CreateBoardRequest;
import com.pm.whiteboard.model.Board;
import com.pm.whiteboard.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponse>  createBoards(@Valid @RequestBody CreateBoardRequest request){
        Board board = boardService.createBoard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(BoardResponse.from(board));

    }
    @GetMapping
    public ResponseEntity<List<BoardResponse>> getAllBoards(){
        List<BoardResponse> boards = boardService.getAllBoards().stream().map(BoardResponse :: from).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(boards);
    }

    @GetMapping("{/boardId}")
    public ResponseEntity<BoardResponse> getAllBoardsByBoardId(@PathVariable  String boardId){
      Board board =  boardService.getBoardById(boardId);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponse> updateBoard(@PathVariable  String boardId, @Valid @RequestBody CreateBoardRequest request){
        Board  board = boardService.updateBoard(boardId, request);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable String boardId){
         boardService.deleteBoard(boardId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
