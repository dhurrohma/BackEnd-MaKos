package com.example.kosproject.model.request;

import com.example.kosproject.model.entity.Facility;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class RoomTypeRequest {

    @NotBlank(message = "Room type is required")
    private String roomType;

    @NotBlank(message = "Facility id is required")
    private List<Facility> facility;
}
