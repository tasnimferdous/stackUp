package com.ibt.StackUp.controller;

import com.ibt.StackUp.entity.Board;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "stackUp/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @PostMapping(path = "/createOrUpdate")
    public Board createOrUpdateBoard(@RequestBody Board board){
        return boardService.create(board);
    }

    @GetMapping(path = "/getAll")
    public List<Board> getAll(){
        return boardService.getAll();
    }

    @DeleteMapping(path = "/delete")
    public MyResponse deleteBoard(@RequestParam long id){
        return boardService.delete(id);
    }
}
