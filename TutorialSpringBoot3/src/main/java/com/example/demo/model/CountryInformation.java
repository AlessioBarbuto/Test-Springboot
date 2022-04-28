package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Cacheable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("countryInformation")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CountryInformation {

    @Id
    private String id;

    private int timeRef;
    private String account;
    private String code;
    private String countryCode;
    private String productType;
    private double value;
    private String Status;

    @CreationTimestamp
    private LocalDateTime creationDate;

}
