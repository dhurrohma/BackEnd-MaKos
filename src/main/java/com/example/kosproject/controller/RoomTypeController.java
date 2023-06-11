package com.example.kosproject.controller;

import com.example.kosproject.model.entity.RoomType;
import com.example.kosproject.model.request.RoomTypeRequest;
import com.example.kosproject.model.response.PagingResponse;
import com.example.kosproject.model.response.SuccessResponse;
import com.example.kosproject.service.RoomTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-type")
@Validated
@CrossOrigin
public class RoomTypeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/add")
    public ResponseEntity create(@RequestBody RoomTypeRequest roomTypeRequest) throws Exception {
        RoomType roomType = modelMapper.map(roomTypeRequest, RoomType.class);
        RoomType result = roomTypeService.create(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success add roomType", result));
    }

    @GetMapping
    public ResponseEntity getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(defaultValue = "roomTypeId") String sortBy
    ) throws Exception {
        Page<RoomType> roomTypes = roomTypeService.findAll(page, size, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Success get event-tenant list", roomTypes));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) throws Exception {
        RoomType roomType = roomTypeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get roomType by id", roomType));
    }

    @GetMapping("/type")
    public ResponseEntity getByRoomTypeNumber(
            @RequestParam String roomType
    ) throws Exception {
        List<RoomType> roomTypes = roomTypeService.findByRoomTypeNumber(roomType);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get roomType by roomTypeNumber", roomTypes));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody RoomType roomType, @PathVariable("id") Integer id) throws Exception {
//        RoomType roomType = modelMapper.map(roomTypeRequest, RoomType.class);
        roomTypeService.updateById(roomType, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success update roomType", roomType));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) throws Exception {
        roomTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success delet roomType", id));
    }
}
