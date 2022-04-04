package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "foodnutrient")
public class FoodNutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fc_id")
    private Long fcId;

    @Column(name = "nutrient_id")
    private Long nutrientId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "data_points")
    private String dataPoints;

    @Column(name = "derivation_id")
    private Long derivationId;

    @Column(name = "min")
    private String min;

    @Column(name = "max")
    private String max;

    @Column(name = "median")
    private String median;

    @Column(name = "foot_note")
    private String footNote;

    @Column(name = "min_year_acquired")
    private String minYearAcquired;

    //TODO Aggiungere data di creazione e modifica (svuotare il db prima) nb: la data di crazione farla
    // mettere da hibernate con annotation [non usare Date ma LocalDateTime]

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "last_modify")
    private Date lastModify;

}
