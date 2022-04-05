package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String location;

    //Un indirizzo, una biblioteca - Foreign Key nella tabella - indico nel mappedBy il nome della tabella stessa
    @OneToOne(mappedBy = "address")
    private Library library;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}
