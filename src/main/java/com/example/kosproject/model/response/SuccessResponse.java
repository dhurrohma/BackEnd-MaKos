package com.example.kosproject.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class SuccessResponse<T> extends CommonResponse {
    T data;
    T id;

    public SuccessResponse(String message, T data) {
        super.setCode("00");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
        this.id = (T)"ok";
    }

    public SuccessResponse(String message, T data, T id) {
        super.setCode("00");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
        this.id = id;
    }
}
