package com.example.demo.commandline;

import com.example.demo.service.Node;
import com.example.demo.service.PrintNodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BinaryTreeCommandLine implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    //inserire un nuovo nodo, ricercare un nodo ed estrarre un nodo

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

/*        log.info("radice (1): "+root.getValue());
        log.info("nodo 2: "+root.getChildren().get(0).getValue());
        log.info("nodo 3: "+root.getChildren().get(1).getValue());
        log.info("nodo 4: "+root.getChildren().get(2).getValue());
        log.info("nodo 5: "+node2.getChildren().get(0).getValue());
        log.info("nodo 6: "+node2.getChildren().get(1).getValue());
        log.info("nodo 7: "+node4.getChildren().get(0).getValue());
        log.info("nodo 8: "+node4.getChildren().get(1).getValue());
        log.info("nodo 9: "+node5.getChildren().get(0).getValue());
        log.info("nodo 10: "+node5.getChildren().get(1).getValue());
        log.info("nodo 11: "+node7.getChildren().get(0).getValue());
        log.info("nodo 12: "+node7.getChildren().get(1).getValue());*/

       /* log.info("nodo 2: "+node2.getChildren().get(0).getValue()+" "+node2.getChildren().get(1).getValue());
        log.info("nodo 5: "+node5.getChildren().get(0).getValue()+" "+node5.getChildren().get(1).getValue());
        log.info("nodo 4: "+node4.getChildren().get(0).getValue()+" "+node4.getChildren().get(1).getValue());
        log.info("nodo 7: "+node7.getChildren().get(0).getValue()+" "+node7.getChildren().get(1).getValue());
*/
        //stampa tutti i nodi
        PrintNodes.printTree(root);
        //Stampa un nodo dato il numero di quel nodo
       // Node nodo = PrintNodes.findNodeByNumber(root, 11);
       // System.out.println(nodo.toString());

    }
}
