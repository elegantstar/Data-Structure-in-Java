package _19_b_tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    List<Integer> keys;
    List<Node> nodes;

    Node(int t) {
        this.keys = new ArrayList<>(2 * t);
        this.nodes = new ArrayList<>(2 * t);
    }
}
