package com.ibt.StackUp.repository;

import com.ibt.StackUp.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<Epic, Long> {
}
