package com.example.demo.Service;

import com.example.demo.model.CountryInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryInformationService extends CSVService {

    /**
     *metodo che mappa un elemento CountryInformation
     * @param arr
     * @return elemento CountryInformation
     */
    public CountryInformation mapCountry(String[] arr){

        CountryInformation countryInformation  = CountryInformation.builder()
                .timeRef(Integer.parseInt(stringChecked(arr, 0)))
                .account(stringChecked(arr, 1))
                .code(stringChecked(arr, 2))
                .countryCode(stringChecked(arr, 3))
                .productType(stringChecked(arr, 4))
                .value(Double.parseDouble(stringChecked(arr, 5)))
                .Status(stringChecked(arr, 6))
                .build();

        return countryInformation;
    }

    /**
     * metodo per mappare la lista nell'oggetto CountryInformation
     * @param listOfLines
     * @return lista di CountryInformation
     */
    public List<CountryInformation> splitLinesAndMap(List<String> listOfLines){

        List<CountryInformation> countryInformations = new ArrayList<>();

        for (String line: listOfLines) {
            String[] arr = line.split("," , -1);
            CountryInformation countryInformation = mapCountry(arr);
            countryInformations.add(countryInformation);

        }
        return countryInformations;
    }
}
