package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;


public class Node{

    private List<Node> children;
    private Integer value;
    private Object data; //al posto di object due classi, una x amici e una x parenti //Object == T


    public Node(Integer value){
        this.value = value;
    }


    public void addChild(Node child){
        if(children == null){
            this.children = new ArrayList<>();
        }
        children.add(child);
    }

    public void removeChild(int index){
        children.remove(index);
    }

    public List<Node> getNodeList(){
        return children;
    }


    //getters e setters
    public List<Node> getChildren() {
        return children;
    }

    public Integer getValue() {
        return value;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "children=" + children +
                ", value=" + value +
                '}';
    }
}
