package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToOne //Una biblioteca, un indirizzo - Foreign Key nella tabella
    @JoinColumn(name = "address_id") //nella join column indico il nome della foreign key
    private Address address;

    @OneToMany(mappedBy = "library") //Una biblioteca, molti libri
    private List<Book> books;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;


}
