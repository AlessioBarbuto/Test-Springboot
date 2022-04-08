package com.example.demo.Service;

import com.example.demo.model.PeopleInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleInformationService extends CSVService {

    /**
     *metodo che mappa un elemento PeopleInformation
     * @param arr
     * @return
     */
    public PeopleInformation mapPeople(String[] arr){

        PeopleInformation peopleInformation = PeopleInformation.builder()
                .year(Integer.parseInt(stringChecked(arr, 0)))
                .age(Integer.parseInt(stringChecked(arr, 1)))
                .ethnic(Integer.parseInt(stringChecked(arr, 2)))
                .sex(Integer.parseInt(stringChecked(arr, 3)))
                .area(stringChecked(arr, 4))
                .count(Double.parseDouble(convertWrongValueOfCount(stringChecked(arr, 5))))
                .build();

        return peopleInformation;
    }

    /**
     * metodo per mappare la lista nell'oggetto PeopleInformation
     * @param listOfLines
     * @return lista di PeopleInformation
     */
    public List<PeopleInformation> splitLinesAndMap(List<String> listOfLines){

        List<PeopleInformation> peopleInformations = new ArrayList<>();

        for (String line: listOfLines) {
            String[] arr = line.split("," , -1);
            PeopleInformation peopleInformation = mapPeople(arr);
            peopleInformations.add(peopleInformation);

        }

        return peopleInformations;
    }

    /**
     * Metodo di utility per correggere il valore "..C" (non valido) presente nel campo "Count" del csv
     * @param s
     * @return
     */
    public String convertWrongValueOfCount(String s) {

        if (s.matches("..C")) {
            s=s.replaceAll("..C", "0");
        }
        return s;

    }

}
