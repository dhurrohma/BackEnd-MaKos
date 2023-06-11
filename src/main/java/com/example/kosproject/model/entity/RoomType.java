package com.example.kosproject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "room_type")
@Getter @Setter
@ToString
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private Integer roomTypeId;
    @Column(name = "room_type")
    private String roomType;

    @ManyToMany
    @JoinTable(name = "type_facility",
                joinColumns = @JoinColumn(name = "type_id"),
                inverseJoinColumns = @JoinColumn(name = "facility_id")
    )
    private Set<Facility> facility;
}
