package com.example.demo.client;

import com.example.demo.entity.Cereal;
import feign.RequestLine;

import java.util.List;

public interface CerealClient {

    @RequestLine("GET")
    List<Cereal> findAllCereals();
}
