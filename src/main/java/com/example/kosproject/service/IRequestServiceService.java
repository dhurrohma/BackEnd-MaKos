package com.example.kosproject.service;

import com.example.kosproject.model.entity.RequestService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRequestServiceService {
    RequestService create(RequestService requestService) throws Exception;
    Page<RequestService> findAll(Integer page, Integer size, String direction, String sortBy);
    RequestService findById(Integer id) throws Exception;
    List<RequestService> findByIsFinished(boolean isFinished);
    void updateById(RequestService requestService, Integer id) throws Exception;
    void deleteById(Integer id) throws Exception;
}
