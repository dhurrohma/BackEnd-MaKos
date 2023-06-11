package com.example.kosproject.controller;

import com.example.kosproject.model.entity.RequestService;
import com.example.kosproject.model.response.PagingResponse;
import com.example.kosproject.model.response.SuccessResponse;
import com.example.kosproject.service.RequestServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request-service")
@Validated
@CrossOrigin
public class RequestServiceController {

    @Autowired
    private RequestServiceService requestServiceService;

    @PostMapping("/add")
    public ResponseEntity create(@RequestBody @Valid RequestService requestService) throws Exception {
        RequestService result = requestServiceService.create(requestService);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success add request service", result));
    }

    @GetMapping
    public ResponseEntity getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(defaultValue = "requestId") String sortBy
    ) throws Exception {
        Page<RequestService> requestServices = requestServiceService.findAll(page, size, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Success get request service list", requestServices));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) throws Exception {
        RequestService requestService = requestServiceService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get request service by id", requestService));
    }

    @GetMapping("/finished")
    public ResponseEntity getByIsFinished(@RequestBody boolean isFinished) {
        List<RequestService> requestServices = requestServiceService.findByIsFinished(isFinished);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get request service by isFinished", requestServices));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @RequestBody RequestService requestService, @PathVariable("id") Integer id) throws Exception {
        requestServiceService.updateById(requestService, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success update request service", requestService));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) throws Exception {
        requestServiceService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success delete request service", id));
    }
}

