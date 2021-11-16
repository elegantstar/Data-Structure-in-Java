package _22_hash_table_using_red_black_tree;

public class Node {
    Node next;

    // TODO : hash는 보조 해시 값으로, 버킷의 크기와 상관 없이 키를 이용하여 계산된 해시값이다.
    // TODO : 키의 값이 변경되지 않는 이상 동일한 보조 해시값을 가지기 때문에 재계산 하지 않도록 저장해둔다.
    final int hash;
    final Object key;
    Object value;

    Node(int hash, Object key, Object value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }
}
