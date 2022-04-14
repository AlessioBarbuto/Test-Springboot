package com.example.demo.service;

import com.example.demo.entity.Company;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CriteriaService {

    @PersistenceContext
    EntityManager entityManager;

    //Criteria Query
    public List<Company> findCompanyByAuthorId(long authorId){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaBuilderQuery = criteriaBuilder.createQuery(Company.class);

        Root<Company> client = criteriaBuilderQuery.from(Company.class);
        Predicate predicate = criteriaBuilder.equal(client.get("author"), authorId);

        criteriaBuilderQuery.where(predicate);
        return entityManager.createQuery(criteriaBuilderQuery).getResultList();

    }

}
