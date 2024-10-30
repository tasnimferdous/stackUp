package com.ibt.StackUp.service;

import com.ibt.StackUp.entity.Board;
import com.ibt.StackUp.entity.Issue;
import com.ibt.StackUp.response.MyResponse;

import java.util.List;

public interface BoardService {
    Board create(Board board);
    List<Board> getAll();
    MyResponse delete(long id);
}
