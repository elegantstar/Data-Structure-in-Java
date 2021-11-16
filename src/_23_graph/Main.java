package _23_graph;

import _23_graph.adjacency_list_graph.AdjacencyListGraph;
import _23_graph.adjacency_matrix_graph.AdjacencyMatrixGraph;

public class Main {
    public static void main(String[] args) {

        /**
         * Graph
         *       0
         *    ↗↙  ↖↘
         *    3     1
         *  ↗↙ ↖↘  ↗↙
         * 4     2
         *        ↖↘
         *          5
         */
        AdjacencyMatrixGraph matrixGraph = new AdjacencyMatrixGraph(6);
        matrixGraph.addUndirectedEdge(0, 1);
        matrixGraph.addUndirectedEdge(1, 2);
        matrixGraph.addUndirectedEdge(2, 3);
        matrixGraph.addUndirectedEdge(0, 3);
        matrixGraph.addUndirectedEdge(3, 4);
        matrixGraph.addUndirectedEdge(2, 5);
        matrixGraph.printEdge();

        matrixGraph.clear();
        matrixGraph.addDirectEdge(0, 1);
        matrixGraph.addDirectEdge(1, 2);
        matrixGraph.addDirectEdge(2, 3);
        matrixGraph.addDirectEdge(0, 3);
        matrixGraph.addDirectEdge(3, 4);
        matrixGraph.addDirectEdge(2, 5);
        matrixGraph.printEdge();

        AdjacencyListGraph listGraph = new AdjacencyListGraph(6);
        listGraph.addUndirectedEdge(0, 1);
        listGraph.addUndirectedEdge(1, 2);
        listGraph.addUndirectedEdge(2, 3);
        listGraph.addUndirectedEdge(0, 3);
        listGraph.addUndirectedEdge(3, 4);
        listGraph.addUndirectedEdge(2, 5);
        listGraph.printEdge();

        listGraph.clear();
        listGraph.addDirectEdge(0, 1);
        listGraph.addDirectEdge(1, 2);
        listGraph.addDirectEdge(2, 3);
        listGraph.addDirectEdge(0, 3);
        listGraph.addDirectEdge(3, 4);
        listGraph.addDirectEdge(2, 5);
        listGraph.printEdge();
    }
}
