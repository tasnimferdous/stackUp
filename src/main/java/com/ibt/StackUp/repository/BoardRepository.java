package com.ibt.StackUp.repository;

import com.ibt.StackUp.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
