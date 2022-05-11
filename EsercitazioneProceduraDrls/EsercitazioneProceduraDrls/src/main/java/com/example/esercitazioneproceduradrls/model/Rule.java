package com.example.esercitazioneproceduradrls.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rule implements Serializable {

    private String name;
    private String dialect;
    private List<Function> when;
    private List<Expression> then;
    //private List<Variable> variables;
    //private List<Expression> expressions;

}
