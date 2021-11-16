package _22_hash_table_using_red_black_tree;

public class TreeNode {

    TreeNode left, right, parent;
    int color = RED;
    int hash;
    Object key;
    Object value;

    static final int RED = 0;
    static final int BLACK = 1;

    TreeNode(int hash, Object key, Object value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }
}
