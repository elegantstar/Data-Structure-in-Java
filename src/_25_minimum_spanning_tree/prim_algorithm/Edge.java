package _25_minimum_spanning_tree.prim_algorithm;

public class Edge implements Comparable<Edge>{
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }

    @Override
    public String toString() {
        return String.format("(u=%s, v=%s, w=%s)", u, v, w);
    }
}
