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
public class Function implements Serializable {

    private String name;
    private String operator;
    private String functionName;
    private List<Condition> conditions;

    @Override
    public String toString() {
        String str = "";
        if(name != null){
            str = str.concat(name);
        }
        if(operator != null){
            str = str.concat(operator);
        }
        if(functionName != null){
            str = str.concat(functionName);
        }
        if(conditions != null){
            str = str.concat(conditions.toString());
        }
        return str;
    }

}
