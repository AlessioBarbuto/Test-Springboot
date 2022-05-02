package com.example.demo.service;

import com.github.javafaker.Bool;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * This class permit to execute the basical operations to execute on a Generic Tree: Print a Tree,
 * Print a node, delete a node ecc.. The following methods are developed using "Recursion" logic.
 */
@Slf4j
public class PrintNodes {

    /**
     * This method print every node of a Generic Tree using Depth Search Logic
     * @param root : the root of the tree
     */
    public static void printTree(Node root){
        System.out.println("printTree --- root Node: " + root.getValue());
        List<Node> rootChildren = root.getNodeList();
        printChildren(rootChildren);
    }

    /**
     * Data una lista di nodi, viene stampato il primo nodo della lista. Si controlla se il nodo ha figli,
     * se il nodo ha figli viene richiamata la funzione ricorsiva passandogli come parametro la lista dei figli,
     * se il nodo non ha figli viene richiamata la funzione ricorsiva passandogli come parametro una sottolista
     * composta dai suoi nodi fratelli.
     * @param nodeList : Lista di nodi (in genere i figli della radice)
     */
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


    /**
     * Metodo di ricerca in profondità, dato un nodo stampo il suo valore;
     *
     * @param root (radice)
     * @param number (valore del nodo da cercare)
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

    /**
     * Data una lista di nodi, viene considerato il primo nodo della lista e si controlla se è il nodo che si sta cercando.
     * Se è il nodo ricercato allora viene ritornato. Altrimenti si controlla se il nodo ha figli,
     * se il nodo ha figli viene richiamata la funzione ricorsiva passandogli come parametro la lista dei figli,
     * se il nodo non ha figli viene richiamata la funzione ricorsiva passandogli come parametro una sottolista
     * composta dai suoi nodi fratelli.
     *
     * @param rootChildren (lista formata dai figli della radice)
     * @param number (valore del nodo da cercare)
     */
    public static Node findNode(List<Node> rootChildren, Integer number){

        Node node = rootChildren.get(0); //prendo il primo nodo figlio
        List<Node> nestedList = node.getChildren(); //ottengo la lista dei suoi figli
        log.info("nodo corrente : "+node.getValue());

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
     * metodo DI INSERIMENTO per aggiungere un nodo specificando dove aggiungerlo.
     * Se specifico il nodo lo inserisco in quella posizione, altrimenti lo mette alla fine.
     *
     * il metodo controlla il valore del parametro "position", se è un numero ed è presente nell'albero allora lo ritrova
     * richiamando la funzione "findNodeByBumber" che ritorna il nodo padre. Dopodichè viene inserito il nuovo nodo.
     * Se il valore del parametro "position" non è presente viene lanciata un'eccezione, altrimenti se non viene specificato nulla
     * Il nodo viene aggiunto alla fine dell'albero.
     *
     * @param root (radice)
     * @param nodeToInsert (Oggetto Nodo da inserire)
     * @param position (Valore del nodo padre in cui inserirlo, può essere un numero o null)
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

/*        for (Node child: rootChildren) {      //approccio strutturale
            List<Node> nestedList = child.getChildren();
            if(nestedList == null){
                child.addChild(nodeToInsert);
                printTree(root);
                return "Tree updated Succesfully";
            }
        }*/

        rootChildren.stream()                  //approccio funzionale
                .filter(nestedList -> nestedList.getChildren() == null) //mettere un predicate oppure
                .forEach(node -> node.addChild(nodeToInsert)); //si puo togliere
        printTree(root);
        return "Tree updated Succesfully";

    }


    /**
     * Metodo che ricerca in profondità un nodo, lo ottiene e lo elimina dal dall'albero;
     *
     * @param root (radice)
     * @param number (valore del nodo da eliminare)
     */
    public static Node delNodeByNumber(Function<String, String> quote ,Node root, Integer number){

        //se root == number ho trovato il nodo
        if(root.getValue() == number){
            return root;
            //altrimenti cerco il nodo
        }else {
            List<Node> rootChildren = root.getChildren();
            return deleteNode(rootChildren, number);
        }

    }


    /**
     * Data una lista di nodi, viene considerato il primo nodo della lista e si controlla se è il nodo che si sta cercando.
     * Se è il nodo ricercato allora viene ritornato. Altrimenti si controlla se il nodo ha figli,
     * se il nodo ha figli viene richiamata la funzione ricorsiva passandogli come parametro la lista dei figli,
     * se il nodo non ha figli viene richiamata la funzione ricorsiva passandogli come parametro una sottolista
     * composta dai suoi nodi fratelli.
     *
     * Quando il nodo da eliminare viene trovato, viene ritornato alla funzione ricorsiva precedente, che possiede l'oggetto Nodo padre e
     * si occuperà di rimuovere il nodo figlio dalla lista.
     *
     * @param rootChildren (lista formata dai figli della radice)
     * @param number (valore del nodo da cercare)
     */
    public static Node deleteNode(List<Node> rootChildren, Integer number){

        Node node = rootChildren.get(0); //prendo il primo nodo figlio
        List<Node> nestedList = node.getChildren(); //ottengo la lista dei suoi figli
        //log.info("nodo corrente : "+node.getValue());

        if (node.getValue() == number){ //controllo che il nodo sia == number
            log.info("trovato il nodo: "+node.getValue());
            return node; //se l'ho trovato lo ritorno, altrimenti proseguo
        }

        if (nestedList != null) { //se il nodo ha figli richiama se stessa
            Node result = deleteNode(nestedList, number);
            if (result != null){ //cancello il nodo dal padre
                log.info("sto cancellando il nodo : "+result.getValue());
                node.removeChild(result);
                return result;
            }
        }

        if (rootChildren.size() > 1) { //se il nodo ha fratelli crea una sottolista
            return deleteNode(rootChildren.subList(1, rootChildren.size()), number);
        }
        return null;

    }

    /**
     * Funzione che utilizza il predicato per determinare l'operazione da compiere con l'oggetto Nodo trovato.
     * @param predicate (è il predicato, contiene la logica)
     * @param rootChildren (Lista di nodi)
     * @param number (valore del nodo chiamato in causa)
     * @return (ritorna un nodo)
     */
    public static Node findOrDeleteWithPredicate(Function<Node, Node> predicate, List<Node> rootChildren, Integer number){

        Node node = rootChildren.get(0);
        List<Node> nestedList = node.getChildren();
        log.info("nodo corrente : "+node.getValue());

        if (node.getValue() == number){
            log.info("trovato il nodo: "+node.getValue());
            return node;
        }

        if (nestedList != null) {
            Node result = findOrDeleteWithPredicate(predicate,nestedList, number);
            if (result != null){
                //predicate.apply()
            }
        }

        if (rootChildren.size() > 1) {
            return findOrDeleteWithPredicate(predicate, rootChildren.subList(1, rootChildren.size()), number);
        }
        return null;

    }

    //logica della find:
    //if (result != null && result.getValue() == number){ return result;}
    BiPredicate<Node, Integer> returnFoundedNode = (node, number) -> node.getValue().equals(number);

    //logica della delete:
    //if (result != null){node.removeChild(result);
    BiConsumer<Node, Node> deleteFoundedNode = Node::removeChild;


    // TODO: commenti + scrivere delete v2.0 (il codice è duplicato) + usare i predicati per generalizzare una funzione

}

//Find List of Nodes (es. Odds & Even)
//Con Generics


