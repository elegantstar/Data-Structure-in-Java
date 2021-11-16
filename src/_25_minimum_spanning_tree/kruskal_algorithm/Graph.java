package _25_minimum_spanning_tree.kruskal_algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

    final PriorityQueue<Edge> priorityQueue; // 우선순위 큐(MinHeap)
    final int[] disjointSet; // 서로소 집합

    public Graph() {
        priorityQueue = new PriorityQueue<>();
        disjointSet = new int[6];

        for (int i = 0; i < disjointSet.length; i++) {
            disjointSet[i] = i;
        }
    }

    public void undirectedEdge(int u, int v, int w) {
        // TODO : 간선을 추가할 때부터 가중치 순으로 정렬하기 위해, 우선순위 큐를 사용한다.
        priorityQueue.add(new Edge(u, v, w));
    }

    private int find(int x) {
        // TODO : 해당 원소의 대표 원소값을 찾는다.
        if (disjointSet[x] == x) {
            return x;
        } else {
            /**
             * return find(disjointSet[x]); 만 작성해도 되나
             * 재귀적인 탐색 횟수를 줄이기 위해
             * 탐색 시 부분 집합의 대표 원소로 변경해 준다.
             *
             * 기존에 이러한 서로소 집합의 상태가 있다고 가정하자.
             * 원소       0   1   2   3   4   5
             * 대표 원소    0   0   1   2   4   5
             *
             * 만약에 find(3)을 호출하면 대표 원소를 찾기 위해
             * 3 -> 2 -> 1 -> 0 순으로 재귀적인 탐색을 해야 한다.
             *
             * 첫 번째 탐색 시 대표 원소를 바로 찾지 못하나, 대표 원소로 변경해 준다면
             * 두 번째 탐색 시에는 바로 대표 원소를 찾을 수 있다.
             * 원소       0   1   2   3   4   5
             * 대표 원소    0   0   0   0   4   5
             */
            return disjointSet[x] = find(disjointSet[x]);
        }
    }

    private void union(int u, int v) {
        u = find(u);
        v = find(v);
        // TODO : 전달 받은 두 원소의 대표 원소 중 작은 원소 값을 대표 원소로 덮어 쓴다.
        if (u < v) {
            disjointSet[v] = u;
        } else {
            disjointSet[u] = v;
        }
    }

    public Set<Edge> getMST() {
        Set<Edge> safeEdgeSet = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            // TODO : 대표 원소가 서로 다르면 서로 다른 부분집합이다.
            if (find(edge.u) != find(edge.v)) {
                /**
                 * 두 원소가 같은 부분 집합에 속해 있지 않을 때만 uinon 연산 후, 간선을 안전 간선으로 추가한다.
                 */
                union(edge.u, edge.v);
                safeEdgeSet.add(edge);
            }
        }
        return safeEdgeSet;
    }
}
