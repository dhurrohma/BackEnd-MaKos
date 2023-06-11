package com.example.kosproject.service;

import com.example.kosproject.exception.EntityExistException;
import com.example.kosproject.exception.NotFoundException;
import com.example.kosproject.model.entity.RoomType;
import com.example.kosproject.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService{

    @Autowired
    private RoomTypeRepository roomTypeRepository;


    public RoomType create(RoomType roomType) throws Exception {
        try {
            return roomTypeRepository.save(roomType);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }


    public Page<RoomType> findAll(Integer page, Integer size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        Page<RoomType> roomTypes = roomTypeRepository.findAll(pageable);
        return roomTypes;
    }


    public RoomType findById(Integer id) throws Exception {
        Optional<RoomType> roomType = roomTypeRepository.findById(id);
        if (roomType.isEmpty()){
            throw new NotFoundException("RoomType not found");
        }
        return roomType.get();
    }


    public List<RoomType> findByRoomTypeNumber(String roomType) throws Exception {
        List<RoomType> roomTypes = roomTypeRepository.findByRoomTypeContains(roomType);
        if (roomTypes.isEmpty()) {
            throw new Exception("RoomType not found");
        }
        return roomTypes;
    }



    public void updateById(RoomType roomType, Integer id) throws Exception {
        try {
            RoomType existRoomType = findById(id);
            roomType.setRoomTypeId(existRoomType.getRoomTypeId());
            roomTypeRepository.save(roomType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteById(Integer id) throws Exception {
        try {
            RoomType existRoomType = findById(id);
            roomTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Delete failed");
        }
    }
}
