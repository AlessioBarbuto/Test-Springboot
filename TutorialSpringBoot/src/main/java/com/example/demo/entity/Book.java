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
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String title;

    @ManyToOne
    @JoinColumn(name="library_id") //Molti libri, una biblioteca.   l'annotazione @JoinColumn configura il nome della colonna nella tabella biblioteca che esegue il mapping alla chiave primaria nella tabella libri.
    private Library library; //nella join column indico il nome della foreign key

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;


    /*@ManyToMany(mappedBy = "books")
    private List<Author> authors;*/

}
