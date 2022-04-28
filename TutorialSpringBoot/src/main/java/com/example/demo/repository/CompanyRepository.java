package com.example.demo.repository;

import com.example.demo.entity.Author;
import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

/*    @Query(value = "SELECT c FROM company WHERE c.name LIKE '?%'", nativeQuery = true)
    List<Company> findCompaniesWithNameContains(String word);*/

    @Query(value = "SELECT c FROM Company c WHERE author_id = :authorId")
    Company findByAuthorId(long authorId);

    //@Query(value = "SELECT a FROM Company c JOIN c.author a JOIN c.book b WHERE c.author.name = :name")
    //List<Author> innerJoin(String name);

}
