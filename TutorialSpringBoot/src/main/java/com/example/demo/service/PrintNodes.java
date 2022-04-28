package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class PrintNodes {

    public static void printTree(Node root){
        System.out.println("printTree --- root Node: " + root.getValue());
        List<Node> rootChildren = root.getNodeList();
        printChildren(rootChildren);
    }

    //ricerca in profondità
    public static void printChildren(List<Node> nodeList){

        Node node = nodeList.get(0);
        List<Node> nestedList = node.getNodeList(); //ottengo la lista figli
        System.out.println("printTree ---- " + node.getValue());

        if(nestedList != null){ //se il nodo ha figli richiama se stessa
            printChildren(nestedList);
        }

        if(nodeList.size() > 1){
            printChildren(nodeList.subList(1, nodeList.size()));
        }

    }

    //NB: gestire le eccezioni

    /**
     * Metodo di ricerca dato un nodo stampo il suo valore;
     * @param root (radice)
     * @param number (numero del nodo)
     */
    public static Node findNodeByNumber(Node root, Integer number){

        //se root == number ho trovato il nodo
        if(root.getValue() == number){
            return root;
            //altrimenti cerco il nodo
        }else {
            List<Node> rootChildren = root.getChildren();
            return findNode(rootChildren, number);
        }

    }
    //find one Node
    public static Node findNode(List<Node> rootChildren, Integer number){

        Node node = rootChildren.get(0); //prendo il primo nodo figlio
        List<Node> nestedList = node.getChildren(); //ottengo la lista dei suoi figli
        //log.info("nodo corrente : "+node.getValue());

        if (node.getValue() == number){ //controllo che il nodo sia == number
            return node; //se l'ho trovato lo ritorno, altrimenti proseguo
        }

        if (nestedList != null) { //se il nodo ha figli richiama se stessa
            Node result = findNode(nestedList, number);
            if (result != null && result.getValue() == number){ return result;}
        }

        if (rootChildren.size() > 1) { //se il nodo non ha figli crea una sottolista
            return findNode(rootChildren.subList(1, rootChildren.size()), number);
        }
        return null;

    }

    /**
     * metodo DI INSERIMENTO per aggiungere un nodo specificando dove aggiungerlo
     * Se specifico il nodo lo inserisco in quella posizione, altrimenti lo mette alla fine
     * @param root
     * @param nodeToInsert
     * @param position
     */
    public static String insertNodeAtPosition(Node root, Node nodeToInsert, Integer position){

        Optional<Integer> n = Optional.ofNullable(position); //se arriva null mi restituisce un oggetto vuoto

        try {
            //se la posizione è != null inserisco il nodo in quella posizione
            if (n.isPresent()) {
                Node nodeAtPosition = findNodeByNumber(root, position);
                nodeAtPosition.addChild(nodeToInsert);
                printTree(root);
                return "Tree updated Successfully";
            }
        }catch (Exception e){
            return "node at \"position\" not exist, please insert a valid value";
        }

        //altrimenti lo inserisco sotto il primo nodo che non ha figli
        List<Node> rootChildren = root.getChildren();

        for (Node child: rootChildren) {
            List<Node> nestedList = child.getChildren();
            if(nestedList == null){
                child.addChild(nodeToInsert);
                printTree(root);
                return "Tree updated Succesfully";
            }
        }
        return null;
    }


    //DELETE FUNCTION
 /*   public static Node deleteNode(Node root, Integer valueOfNode){

        if(root.getValue() == valueOfNode){
            return root;
            //altrimenti cerco il nodo
        }
            List<Node> rootChildren = root.getChildren();
            return findNode(rootChildren, valueOfNode);
    }*/


    /**Metodo per eliminare un Nodo dato il suo valore.
     */
    public static void delNodeByNumber(Node root, Integer number){

        //se root == number ho trovato il nodo
        if(root.getValue() == number){
            root = null;
            //altrimenti cerco il nodo
        }else {
            List<Node> rootChildren = root.getChildren();
            deleteNode(rootChildren, number);
        }

    }

    public static Node deleteNode(List<Node> rootChildren, Integer number){

        Node node = rootChildren.get(0); //prendo il primo nodo figlio
        List<Node> nestedList = node.getChildren(); //ottengo la lista dei suoi figli
        //log.info("nodo corrente : "+node.getValue());

        if (node.getValue() == number){ //controllo che il nodo sia == number
            return node; //se l'ho trovato lo ritorno, altrimenti proseguo
        }

        if (nestedList != null) { //se il nodo ha figli richiama se stessa
            Node result = findNode(nestedList, number);
            if (result != null && result.getValue() == number){ return result;}
        }

        if (rootChildren.size() > 1) { //se il nodo non ha figli crea una sottolista
            return findNode(rootChildren.subList(1, rootChildren.size()), number);
        }
        return null;

    }



//Find List of Nodes (es. Odds & Even)
    public static List<Node> findListOfNodes(){

        return null;
    }


}






//Con Generics


