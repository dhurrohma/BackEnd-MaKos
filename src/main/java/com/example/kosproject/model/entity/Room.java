package com.example.kosproject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "room")
@Getter @Setter
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;


    @Column(name = "room_description")
    private String roomDescription;

    @Column(name = "room_available", nullable = false)
    private boolean roomAvailable;

    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_type_id")
    private RoomType roomType;
}
