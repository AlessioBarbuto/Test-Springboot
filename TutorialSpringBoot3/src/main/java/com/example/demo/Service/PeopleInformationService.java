package com.example.demo.Service;

import com.example.demo.model.PeopleInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleInformationService extends CSVService {

//    @PersistenceContext
      EntityManager entityManager;

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

//Criteria Query
    public List<PeopleInformation> getAllPeopleByAreaAndCount(String area, Long count){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PeopleInformation> criteriaBuilderQuery = criteriaBuilder.createQuery(PeopleInformation.class);

        Root<PeopleInformation> client = criteriaBuilderQuery.from(PeopleInformation.class);
        List<Predicate> predicates = new ArrayList<>();

        //in criteria posso aggiungere ordinamento, paginazione ecc..
        if (area != null) {
            predicates.add(criteriaBuilder.equal(client.get("area"), area));
        }
        if (count != null) {
            predicates.add(criteriaBuilder.like(client.get("count"), "%" + count + "%"));
        }

        //trasformo criteria in array di predicati
        criteriaBuilderQuery.where(predicates.toArray(new Predicate[0]))
                .orderBy(criteriaBuilder.asc(client.get("idClient"))); //ordinamento

        return entityManager.createQuery(criteriaBuilderQuery).getResultList();

    }




}
