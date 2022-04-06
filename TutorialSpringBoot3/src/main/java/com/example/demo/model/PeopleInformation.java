package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("peopleInformation")
public class PeopleInformation {

    @Id
    private String id;

    private int Year;
    private int Age;
    private int Ethnic;
    private int Sex;
    private int Area;
    private int count;

    @CreationTimestamp
    private LocalDateTime creationDate;

}
