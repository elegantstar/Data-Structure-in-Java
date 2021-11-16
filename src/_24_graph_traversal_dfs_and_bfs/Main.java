package _24_graph_traversal_dfs_and_bfs;

import _24_graph_traversal_dfs_and_bfs.adjacency_list_graph.AdjacencyListGraph;
import _24_graph_traversal_dfs_and_bfs.adjacency_matrix_graph.AdjacencyMatrixGraph;

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
        matrixGraph.dfsTraversal(3);
        matrixGraph.bfsTraversal(3);

        AdjacencyListGraph listGraph = new AdjacencyListGraph(6);
        listGraph.addUndirectedEdge(0, 1);
        listGraph.addUndirectedEdge(1, 2);
        listGraph.addUndirectedEdge(2, 3);
        listGraph.addUndirectedEdge(0, 3);
        listGraph.addUndirectedEdge(3, 4);
        listGraph.addUndirectedEdge(2, 5);
        listGraph.dfsTraversal(3);
        listGraph.bfsTraversal(3);

    }
}
