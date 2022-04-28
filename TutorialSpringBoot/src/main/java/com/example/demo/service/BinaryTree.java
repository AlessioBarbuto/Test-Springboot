package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

public class BinaryTree {

    private Node leftNode;
    private Node rightNode;


    public BinaryTree(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void addLeftNode(Node leftNode){
            this.leftNode = leftNode;
    }
    public void addRightNode(Node rightNode){
        this.rightNode = rightNode;
    }


    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

}
