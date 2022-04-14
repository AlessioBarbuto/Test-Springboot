package com.example.demo.commandline;

import com.example.demo.entity.Author;
import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;

public class TransactionsCommandLine implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
    /*
        //gestisco l'eccezione fa rollback lo stesso
        try {
            createWithCheckedException(new Company("Tizio", new Author()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //gestisco l'eccezione non fa rollback
        try {
            createWithNoRollBack(new Company("Caio", new Author()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createWithProgrammatic(new Company("Caio", new Author()));

        */
    }

    /** Approccio Dichiarativo **/
    @Transactional(rollbackFor = { SQLException.class })
    public void createWithCheckedException(Company company) throws SQLException {
        companyRepository.save(company);
        throw new SQLException("Throwing exception for rollback");
    }

    @Transactional
    public void createWithNoRollBack(Company company) throws SQLException {
        companyRepository.save(company);
        throw new SQLException("Throwing exception for rollback");
    }

    /** Approccio programmatico **/
    public void createWithProgrammatic(Company company) {
        try {
            companyRepository.save(company);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
