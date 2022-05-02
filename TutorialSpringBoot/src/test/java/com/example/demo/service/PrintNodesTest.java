package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PrintNodesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printTree() {
    }

    @Test
    void printChildren() {
    }

    @Test
    void findNodeByNumber() {
    }

    @Test
    void findNodeTest() {
        Node root = new Node(1);
        root.addChild(new Node(2));
        root.addChild(new Node(3));
        root.addChild(new Node(4));

        Node node2 = root.getChildren().get(0);
        node2.addChild(new Node(5));
        node2.addChild(new Node(6));

        Node node4 = root.getChildren().get(2);
        node4.addChild(new Node(7));
        node4.addChild(new Node(8));

        Node node5 = node2.getChildren().get(0);
        node5.addChild(new Node(9));
        node5.addChild(new Node(10));

        Node node7 = node4.getChildren().get(0);
        node7.addChild(new Node(11));
        node7.addChild(new Node(12));

        //CHECK ON 11th NODE;
        //Node nodo11 = PrintNodes.findNodeByNumber(root, 11);
        //assertEquals(node7.getChildren().get(0), nodo11);

        //CHECK ON 12th NODE
        //Node nodo12 = PrintNodes.findNodeByNumber(root, 12);
        //assertEquals(node7.getChildren().get(1), nodo12);

    }


    @Test
    void insertNodeAtPosition() {

        Node root = new Node(1);
        root.addChild(new Node(2));
        root.addChild(new Node(3));
        root.addChild(new Node(4));

        Node node2 = root.getChildren().get(0);
        node2.addChild(new Node(5));
        node2.addChild(new Node(6));

        Node node4 = root.getChildren().get(2);
        node4.addChild(new Node(7));
        node4.addChild(new Node(8));

        Node node5 = node2.getChildren().get(0);
        node5.addChild(new Node(9));
        node5.addChild(new Node(10));

        Node node7 = node4.getChildren().get(0);
        node7.addChild(new Node(11));
        node7.addChild(new Node(12));


        PrintNodes.insertNodeAtPosition(root, new Node(13) ,null);
    }

    @Test
    void delNodeByNumber() {
        Node root = new Node(1);
        root.addChild(new Node(2));
        root.addChild(new Node(3));
        root.addChild(new Node(4));

        Node node2 = root.getChildren().get(0);
        node2.addChild(new Node(5));
        node2.addChild(new Node(6));

        Node node4 = root.getChildren().get(2);
        node4.addChild(new Node(7));
        node4.addChild(new Node(8));

        Node node5 = node2.getChildren().get(0);
        node5.addChild(new Node(9));
        node5.addChild(new Node(10));

        Node node7 = node4.getChildren().get(0);
        node7.addChild(new Node(11));
        node7.addChild(new Node(12));


       // PrintNodes.printTree(root);
       // PrintNodes.delNodeByNumber(,root ,6);
       // log.info("-----------------------------------------");
       // PrintNodes.printTree(root);

    }

}