package _25_minimum_spanning_tree.kruskal_algorithm;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();
        /**
         * Undirected Graph
         *           0
         *      (2)↗↙  ↖↘(3)
         *        3      1
         *   (2)↗↙ ↖↘(3)↗↙(1)
         *     4      2
         *            ↖↘(3)
         *              5
         */
        graph.undirectedEdge(1, 0, 3);
        graph.undirectedEdge(3, 0, 2);
        graph.undirectedEdge(1, 2, 1);
        graph.undirectedEdge(2, 3, 3);
        graph.undirectedEdge(4, 3, 2);
        graph.undirectedEdge(2, 5, 3);
        System.out.println(graph.getMST());

    }
}
