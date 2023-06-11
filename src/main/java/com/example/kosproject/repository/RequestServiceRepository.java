package com.example.kosproject.repository;

import com.example.kosproject.model.entity.RequestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RequestServiceRepository extends JpaRepository<RequestService, Integer>, PagingAndSortingRepository<RequestService, Integer> {
    @Query("SELECT rs FROM RequestService rs WHERE rs.isFinished = :isFinished")
    List<RequestService> findByIsFinished(boolean isFinished);
}

