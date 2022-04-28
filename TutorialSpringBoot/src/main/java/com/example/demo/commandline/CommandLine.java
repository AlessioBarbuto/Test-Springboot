package com.example.demo.commandline;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Company;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CriteriaService;
import com.example.demo.service.PopolamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Slf4j
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PopolamentoService popolamentoService;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CriteriaService criteriaService;

    @Override
    public void run(String... args) {

        //log.info("popolo il db");
        // popolamentoService.populateDB();

/*        log.info("eseguo query");
        List<Company> companies = companyRepository.findCompaniesWithNameContains("A");
        log.info("ritorno: "+Arrays.toString(companies.toArray()));
        log.info("query eseguita");*/

        /**Combinare il risultato di 3 tabelle (inventare indirizzo autore). Query che interroga 3 tabelle
         //(es. che estrae tutti i libri di un autore + azienda dell'autore(da un'altra tabella)) **/

        /*
        //recupero autore dal nome
        log.info("eseguo query1");
        List<Author> authorList = authorRepository.findByName("Jakob");
        log.info("ritorno: "+authorList.stream());
        //recupero l'id dell'autore
        Long authorId = authorList.get(0).getId();;

        //Libri da id Autore
        log.info("eseguo query2");
        Optional<Book> bookList = bookRepository.findById(authorId);
        log.info("ritorno: "+ bookList);

        //azienda dell' Autore
        //log.info("eseguo query3");
        //Company company = companyRepository.findByAuthorId(authorId);
        //log.info("ritorno: "+ company.getName());

        //azienda dell' Autore
        log.info("eseguo query4");
        List<Company> companies = criteriaService.findCompanyByAuthorId(authorId);
        log.info("ritorno: "+ companies.get(0).getName());

        //Faccio la stessa cosa delle 3 query sopra ma con una Join
        log.info("inner join:");
        List<Author> companies1 = companyRepository.innerJoin("Tressa");
        log.info("ritorno: "+companies1.get(0).getCompany());

*/
    }



}
