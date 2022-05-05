package com.example.demo.controller;

import com.example.demo.domain.OrderEvent;
import com.example.demo.domain.OrderEventType;
import com.example.demo.producer.OrderEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class OrderEventsController {

    @Autowired
    OrderEventProducer orderEventProducer;

    @PostMapping("/orderEvent")
    public ResponseEntity<OrderEvent> postLibraryEvent(@RequestBody @Valid OrderEvent orderEvent)
            throws JsonProcessingException, ExecutionException, InterruptedException {

        //invoke kafka producer
        orderEvent.setOrderEventType(OrderEventType.NEW);
        orderEventProducer.sendOrderEvent(orderEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderEvent);
    }

    //PUT
    @PutMapping("/orderEvent")
    public ResponseEntity<?> putLibraryEvent(@RequestBody @Valid OrderEvent orderEvent) throws JsonProcessingException, ExecutionException, InterruptedException {


        if(orderEvent.getOrderEventId()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please pass the OrderEventId");
        }

        orderEvent.setOrderEventType(OrderEventType.UPDATE);
        orderEventProducer.sendOrderEvent(orderEvent);
        return ResponseEntity.status(HttpStatus.OK).body(orderEvent);
    }
}