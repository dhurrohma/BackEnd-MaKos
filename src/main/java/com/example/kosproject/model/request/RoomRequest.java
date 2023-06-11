package com.example.kosproject.model.request;

import com.example.kosproject.model.entity.Facility;
import com.example.kosproject.model.entity.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter @Setter
@ToString
public class RoomRequest {

    @NotBlank(message = "Room Number is required")
    private String roomNumber;

    @NotBlank(message = "Room type is required")
    private RoomType roomType;
    @NotBlank(message = "Room description is required")
    private String roomDescription;

//    @NotBlank(message = "Room available status is required")
//    private boolean roomAvailable;

    @NotBlank(message = "Facility id is required")
    private List<Facility> facility;
}
