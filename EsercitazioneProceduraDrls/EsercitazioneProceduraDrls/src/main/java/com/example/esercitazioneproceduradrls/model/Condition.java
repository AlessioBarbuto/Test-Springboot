package com.example.esercitazioneproceduradrls.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Condition implements Serializable {

    private String name;
    private String operator;
    private String expression;

}
