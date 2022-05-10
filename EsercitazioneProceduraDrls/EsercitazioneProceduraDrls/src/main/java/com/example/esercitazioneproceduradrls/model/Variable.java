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
public class Variable implements Serializable {

    private String type;
    private String name;
    private static final String OPERATOR = "=";
    private String expression;

}
