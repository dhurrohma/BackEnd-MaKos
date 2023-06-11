package com.example.kosproject.service;

import com.example.kosproject.exception.EntityExistException;
import com.example.kosproject.exception.NotFoundException;
import com.example.kosproject.model.entity.RequestService;
import com.example.kosproject.repository.RequestServiceRepository;
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
public class RequestServiceService implements IRequestServiceService {
    @Autowired
    private RequestServiceRepository requestServiceRepository;

    @Override
    public RequestService create(RequestService requestService) throws Exception {
        try {
            return requestServiceRepository.save(requestService);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Page<RequestService> findAll(Integer page, Integer size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        Page<RequestService> requestServices = requestServiceRepository.findAll(pageable);
        return requestServices;
    }

    @Override
    public RequestService findById(Integer id) throws Exception {
        Optional<RequestService> requestService = requestServiceRepository.findById(id);
        if (requestService.isEmpty()){
            throw new NotFoundException("Request service not found");
        }
        return requestService.get();
    }

    @Override
    public List<RequestService> findByIsFinished(boolean isFinished) {
        List<RequestService> requestServices = requestServiceRepository.findByIsFinished(isFinished);
        if (requestServices.isEmpty()){
            throw new NotFoundException("Request service not found");
        }
        return requestServices;
    }

    @Override
    public void updateById(RequestService requestService, Integer id) throws Exception {
        try {
            RequestService existRequest = findById(id);
            requestService.setRequestId(existRequest.getRequestId());
            requestServiceRepository.save(requestService);
        } catch (Exception e) {
            throw new RuntimeException("Update failed");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try {
            RequestService existRequest = findById(id);
            requestServiceRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Delete failed");
        }
    }
}
