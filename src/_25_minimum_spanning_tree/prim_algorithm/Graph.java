package _25_minimum_spanning_tree.prim_algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
    // 인접 리스트 그래프

    final LinkedList<Edge>[] graph;
    final boolean[] visit;

    @SuppressWarnings("unchecked")
    public Graph() {
        graph = new LinkedList[6];
        visit = new boolean[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void undirectedEdge(int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public Set<Edge> getMST() {
        Set<Edge> safeEdgeSet = new HashSet<>();
        /**
         * 0번 정점을 최초 방문 정점으로 한다.
         * 정점 큐 대신 vertex 변수로도 해당 문제를 해결할 수 있으므로
         * vertex 변수를 덮어 씌우는 방식으로 정점을 확인한다.
         */
        int vertex = 0;
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        while (!visit[vertex]) {
            visit[vertex] = true;
            /**
             * 일단 정점 기준으로 방문하지 않은 간선을 추가한다.
             */
            for (Edge edge : graph[vertex]) {
                if (!visit[edge.v]) {
                    edgeQueue.add(edge);
                }
            }
            while (!edgeQueue.isEmpty()) {
                Edge edge = edgeQueue.poll();
                /**
                 * 간선 중 방문하지 않은 정점의 도착지인 간선만 안전 간선으로 추가한다.
                 * 방문 여부를 다시 체크하는 이유는, 정점 방문 시 연관된 간선들을 별도로 제거하지 않기 때문이다.
                 */
                if (!visit[edge.v]) {
                    vertex = edge.v;
                    safeEdgeSet.add(edge);
                    break;
                }
            }
        }
        return safeEdgeSet;
    }
}
