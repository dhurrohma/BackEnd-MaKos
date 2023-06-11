package com.example.kosproject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tenancy")
@Getter @Setter
@ToString
public class Tenancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenancy_id")
    private Integer tenancyId;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "price_id")
    private RoomPrice roomPrice;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "book_date", nullable = false)
    private Date bookDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToMany
    @JoinTable(name = "tenancy_user",
            joinColumns = @JoinColumn(name = "tenancy_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> user;
}
