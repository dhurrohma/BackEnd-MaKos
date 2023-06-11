package com.example.kosproject.repository;

import com.example.kosproject.model.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer>, PagingAndSortingRepository<RoomType, Integer> {
    List<RoomType> findByRoomTypeContains(String roomType) throws Exception;
}
