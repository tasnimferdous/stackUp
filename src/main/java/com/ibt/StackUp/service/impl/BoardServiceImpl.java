package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.Board;
import com.ibt.StackUp.entity.Epic;
import com.ibt.StackUp.entity.Issue;
import com.ibt.StackUp.repository.BoardRepository;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    public Board create(Board board) {
        Board newBoard = null;
        if(board.getName() ==null || board.getName().isEmpty()){
            throw new NullPointerException("Name can't be null or empty");
        }
        try {
            newBoard = boardRepository.save(board);
        }catch (Exception e){
            e.printStackTrace();
        }
        return newBoard;
    }


    @Override
    public List<Board> getAll() {
        List<Board> boardList = null;
        try{
            boardList = boardRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data.");
        }

        return boardList;
    }

    @Override
    public MyResponse delete(long id) {
        String message = "Success";
        boolean err = false;

        try {
            if(boardRepository.findById(id).isEmpty()){
                return MyResponse.builder()
                        .hasError(true)
                        .message("Data not found")
                        .build();
            }
            boardRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to delete the board";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .build();
    }
}
