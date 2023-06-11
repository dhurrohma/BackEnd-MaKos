package com.example.kosproject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "request_service")
@Getter @Setter
@ToString
public class RequestService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @ManyToOne
    @JoinColumn(name = "tenancy_id", referencedColumnName = "tenancy_id")
    private Tenancy tenancy;

    @Column(name = "request")
    private String request;

    @Column(name = "is_finsihed")
    private boolean isFinished;
}
