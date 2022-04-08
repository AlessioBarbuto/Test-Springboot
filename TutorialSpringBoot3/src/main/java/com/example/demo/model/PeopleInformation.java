package com.example.demo.model;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("peopleInformation")
public class PeopleInformation {

    @BsonProperty("_id")
    @BsonId
    private ObjectId id;

    private int year;
    private int age;
    private int ethnic;
    private int sex;
    private String area;
    private Double count;

    @CreationTimestamp
    private LocalDateTime creationDate;

}
