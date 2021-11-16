package _24_graph_traversal_dfs_and_bfs.adjacency_list_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListGraph {

    // 행의 인덱스는 정점을 표현하고, 노드는 간선 존재 여부를 표현한다.
    final LinkedList<Edge>[] graph;
    final int[] visit;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int size) {
        // TODO : 입력 받은 size 만큼의 정점 수를 갖는 LinkedList 배열을 graph로 한다.
        // TODO : 방문 여부를 확인할 수 있는 배열을 만든다. 정점의 개수와 동일한 크기의 배열.
        graph = new LinkedList[size];
        visit = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            // TODO : graph 배열의 모든 공간에 각각 LinkedList를 생성하여 삽입한다.
            graph[i] = new LinkedList<>();
        }
    }

    public void clear() {
        // TODO : visit 배열의 모든 공간을 0으로 채운다.
        Arrays.fill(visit, 0);
        for (int i = 0; i < graph.length; i++) {
            // TODO :graph[i]에 저장된 LinkedList를 초기화한다.
            graph[i].clear();
        }
    }

    private void addEdge(int u, int v, int w) {
        // TODO : edge를 새로 만들고, 입력 받은 매개 변수를 삽입한다.
        Edge edge = new Edge();
        edge.u = u;
        edge.v = v;
        edge.w = w;
        // TODO : 새로 만든 edge를 graph[u]의 LinkedList에 추가한다.
        graph[u].add(edge);
        /**
         * 굳이 정렬할 필요는 없으나 인접 행렬과 탐색 순서를 동일하게 하기 위해 삽입 순서에 상관 없이 간선을 정렬한다.
         */
        graph[u].sort(((o1, o2) -> o1.v - o2.v));
    }

    public void addUndirectedEdge(int u, int v) {
        // TODO : 무방향 간선
        addUndirectedEdge(u, v, 0);
    }

    public void addUndirectedEdge(int u, int v, int w) {
        // TODO : 무방향 간선
        addEdge(u, v, w);
        addEdge(v, u, w);
    }

    public void addDirectEdge(int u, int v) {
        // TODO : 방향 간선
        addDirectEdge(u, v, 0);
    }

    public void addDirectEdge(int u, int v, int w) {
        // TODO : 방향 간선
        addEdge(u, v, w);
    }

    public void dfsTraversal(int start) {
        // TODO : start 매개 변수는 탐색을 시작하는 정점이다.
        // TODO : visit 배열의 모든 원소를 0으로 세팅한다.
        Arrays.fill(visit, 0);
        System.out.println("---List dfs---");
        dfs(start);
        System.out.println("--------------");
    }

    void dfs(int u) {
        // TODO : 깊이 우선 탐색
        if (visit[u] == 1) {
            // TODO : 정점 u를 방문했다면 종료.
            return;
        }
        // TODO : 정점 u를 방문하지 않았으므로, 방문 처리한다.
        visit(u);
        for (Edge edge : graph[u]) {
            // TODO : 정점 u로부터 연결된 정점들을 탐색한다.
            if (visit[edge.v] == 0) {
                // TODO : 방문하지 않은 정점 v가 있다면, 정점 v로부터 깊이 우선 탐색을 시작한다.
                dfs(edge.v);
            }
        }
    }

    public void bfsTraversal(int start) {
        // TODO : start 매개 변수는 탐색을 시작하는 정점이다.
        // TODO : visit 배열의 모든 원소를 0으로 세팅한다.
        Arrays.fill(visit, 0);
        System.out.println("---List bfs---");
        bfs(start);
        System.out.println("--------------");
    }

    void bfs(int start) {
        // TODO : 너비 우선 탐색
        // TODO : BFS를 위한 queue를 생성한다.
        Queue<Integer> queue = new LinkedList<>();
        // TODO : 생성한 queue에 시작 정점을 삽입한다.
        queue.add(start);

        // TODO : queue가 비어 있을 때까지 반복 수행
        while (!queue.isEmpty()) {
            // TODO : queue에 삽입된 정점을 꺼내 u로 저장한다.
            int u = queue.poll();
            // TODO : 정점 u를 방문처리 한다.
            visit(u);
            // TODO : 정점 u로부터 연결된 정점들을 탐색한다.
            for (Edge edge : graph[u]) {
                // TODO : 방문하지 않은 정점 v가 있다면, 해당 정점 v를 queue에 삽입하고 방문처리 한다.
                if (visit[edge.v] == 0) {
                    queue.add(edge.v);
                    visit[edge.v] = 1;
                }
            }
        }
    }

    void visit(int vertex) {
        System.out.printf("vertex:%d\n", vertex);
        visit[vertex] = 1;
    }

    public void printEdge() {
        System.out.println("---List Edge---");
        for (List<Edge> edges : graph) {
            for (Edge edge : edges) {
                System.out.printf("(%d, %d, %d) ", edge.u, edge.v, edge.w);
            }
        }
        System.out.println("\n---------------");
    }
}
