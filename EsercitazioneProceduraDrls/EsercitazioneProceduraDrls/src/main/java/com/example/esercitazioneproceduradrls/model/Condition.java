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
    private Function function;

    @Override
    public String toString() {
        String str = "(";
        if(name != null){
            str = str.concat(name);
        }
        if(operator != null){
            str = str.concat(operator);
        }
        if(function != null){
            str = str.concat(function.toString());
        }
        str = str.concat(")");
        return str;
    }
}
