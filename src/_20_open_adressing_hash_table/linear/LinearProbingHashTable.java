package _20_open_adressing_hash_table.linear;

/**
 * Linear Probing Hash Table의 시간 복잡도
 * 검색 -> 평균: O(1)   최악: O(n)
 * 삽입 -> 평균: O(1)   최악: O(n)
 * 삭제 -> 평균: O(1)   최악: O(n)
 */
public class LinearProbingHashTable {
    // 버킷으로 할당할 수 있는 최대 크기(int의 범위가 32bits이므로, 최상위 부호 비트 직전까지 shift. 즉, 2^30)
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    // 버킷의 엔트리가 75%를 넘으면 버킷의 크기를 늘린다.
    private static final float ROAD_FACTOR_THRESHOLD = 0.75F;

    private Entry[] bucket;
    private int bucketSize;
    private final Entry dummyNull = new Entry(null, null, true);

    public LinearProbingHashTable() {
        this(16);
    }

    public LinearProbingHashTable(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("정상적인 해시 테이블의 크기를 정해주세요");
        }
        bucket = new Entry[tableSizeFor(capacity)];
    }

    private int tableSizeFor(int capacity) {
        // TODO : 2의 제곱수로 bucket 사이즈를 상향식으로 보정한다. (예: 100 -> 128)
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 15;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private int secondaryHash(Object key) {
        /**
         * 보조 해시 함수 : h'(k) -> {0, 1, 2, ..., m - 1}
         * 해시값을 최대한 흩어 놓기 위해 앞의 16비트를 옮겨 기존의 해시값과 XOR 연산을 먼저 한 후
         * bucket 크기 만큼의 범위에 들어가게 하기 위해 비트 연산을 한다.
         *
         * 만약에 최적화를 한다면 h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)로      // ^ : XOR
         * 연산된 값을 노드에 저장하여 재이용하면 된다.
         */
        int h;
        h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return h & (bucket.length - 1);
    }

    private int hash(Object key, int i) {
        /**
         * h(key, i) : h'(k) + i mod m
         */
        int m = bucket.length;
        return (secondaryHash(key) + i) % m;
    }

    private int probing(Object key) {
        /**
         * 키의 조사를 위해 Dummy null 엔트리도 null로 판단하지 않는 조사 방식
         *
         * T[h'(k)]부터 T[m-1]까지 동일한 키가 있거나 빈 공간이 있는지 탐색한다.
         * T[h'(k)]부터 T[m-1]까지 찾지 못했으면 T[0]부터 T[h'(k)-1]까지 탐색한다.
         *
         * return 동일한 키의 인덱스 or 빈 공간의 인덱스 or 동일하지 않은 키의 인덱스
         */
        int m = bucket.length;
        int bucketIndex = -1;
        for (int i = 0; i < m; i++) {
            bucketIndex = hash(key, i);
            if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
                // 동일한 키를 찾은 경우
                break;
            } else if (bucket[bucketIndex] == null) {
                // bucket[bucketIndex]가 null인 경우
                break;
            }
        }
        return bucketIndex;
    }

    private int insertProbing(Object key) {
        /**
         * 키의 삽입을 위해 Dummy null 엔트리를 null로 판단하는 조사 방식
         *
         * T[h'(k)]부터 T[m-1]까지 동일한 키가 있거나 빈 공간이 있는지 탐색한다.
         * T[h'(k)]부터 T[m-1]까지 찾지 못했으면 T[0]부터 T[h'(k)-1]까지 탐색한다.
         *
         * return 동일한 키의 인덱스 or 빈 공간의 인덱스 or 동일하지 않은 키의 인덱스
         */
        int m = bucket.length;
        int bucketIndex = -1;
        for (int i = 0; i < m; i++) {
            bucketIndex = hash(key, i);
            if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
                // 동일한 키를 찾은 경우
                break;
            } else if (bucket[bucketIndex] == null || (bucket[bucketIndex] != null
                                                       && bucket[bucketIndex].isDeleted)) {
                // bucket[bucketIndex]가 null이거나 Dummy null 엔트리 존재 시
                break;
            }
        }
        return bucketIndex;
    }

    public void put(Object key, Object value) {
        putValue(key, value);
    }

    private void putValue(Object key, Object value) {
        /**
         * 조사된 버킷의 위치에 저장된 값이 null이 아니고 이미 동일한 키가 존재하면 값을 덮어 쓴다.
         * null이면 해당 자리에 키와 값을 저장한다.
         */
        int bucketIndex = insertProbing(key);  // 삽입할 위치 탐색.
        if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
            // 버킷에 동일한 키가 존재 시
            bucket[bucketIndex].value = value;
        } else if (bucket[bucketIndex] == null || (bucket[bucketIndex] != null
                                                   && bucket[bucketIndex].isDeleted)) {
            // bucket[index]가 null이거나 Dummy null 엔트리 존재 시
            bucket[bucketIndex] = new Entry(key, value, false);
            ++bucketSize;
        }
        resizeBucket();
    }

    public Object get(Object key) {
        int bucketIndex = probing(key);
        Entry entry = null;
        if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
            entry = bucket[bucketIndex];
        }
        return (entry != null) ? entry.value : null;
    }

    public void remove(Object key) {
        /**
         * 삭제된 노드의 index를 기준으로, 동일한 해시값이거나 또는 해시값보다 이전의 값을 가진 노드를 조사하여 당겨온다.
         * 다만 충돌로 인해 삽입된 키의 해시값이 버킷의 인덱스보다 큰 경우가 있으므로 Lazy Deletion 방식을 택한다.
         *
         * 예) key21, key22, key23 순서대로 해시 테이블에 삽입했을 경우
         * key21, key22, key23은 해시값이 5라고 가정한다.
         * | 0 | (hash : 5, key : key22)
         * | 1 | (hash : 5, key : key23)
         * | 2 | null
         * | 3 | null
         * | 4 | null
         * | 5 | (hash : 5, key : key21)
         *
         * 만약에 key21을 제거하면 이런 상황이 된다.
         * | 0 | (hash : 5, key : key22)
         * | 1 | (hash : 5, key : key23)
         * | 2 | null
         * | 3 | null
         * | 4 | null
         * | 5 | null
         *
         * 그리고 key23(hash 5)을 조사하는 경우 5번 인덱스가 null이기 때문에 조사를 멈춘다.
         * 그러면 key23을 찾지 못 하기 때문에 당겨올 때 Dummy null 엔트리를 넣어주면 조사를 계속 진행할 수 있다.
         * | 0 | (hash : 5, key : key22, isDelete: false)
         * | 1 | (hash : 5, key : key23, isDelete: false)
         * | 2 | null
         * | 3 | null
         * | 4 | null
         * | 5 | (key : null, isDelete: true) <- Dummy null 엔트리
         *
         * 이것은 open-addressing의 한계점이다.
         */
        int index = probing(key);
        int removedIndex = -1;
        if (bucket[index] != null && key.equals(bucket[index].key)) {
            // TODO : Dummy null 엔트리를 삽입한다.
            bucket[index] = this.dummyNull;
            removedIndex = index;
            --bucketSize;
        }

        // TODO : 끌어당기기 로직
        if (removedIndex != -1) {
            int nullIndex = removedIndex;
            for (int i = 0; i < bucket.length; i++) {
                int moveIndex = (i + removedIndex) % bucket.length;
                if (bucket[moveIndex] != null && !bucket[moveIndex].isDeleted &&
                    secondaryHash(bucket[moveIndex].key) <= nullIndex) {
                    // bucket[moveIndex]가 null이 아니며,
                    // Dummy null 엔트리도 아니고,
                    // 해시값이 nullIndex 보다 작거나 같은 경우
                    // TODO : 버킷의 moveIndex에 있는 엔트리를 nullIndex로 이동
                    bucket[nullIndex] = bucket[moveIndex];
                    bucket[moveIndex] = this.dummyNull;
                    nullIndex = moveIndex;
                }
            }
        }
    }

    private void resizeBucket() {
        // TODO : 적재율이 임계치를 넘으면 버킷의 크기를 줄인다.
        int preBucketSize = bucket.length;
        if (preBucketSize >= MAXIMUM_CAPACITY) {
            // TODO : 이미 최대 버킷 크기이면 크기를 늘릴 수 없다.
            return;
        }
        if (bucketSize * 1.0F / preBucketSize > ROAD_FACTOR_THRESHOLD) {
            int newBucketSize = tableSizeFor(preBucketSize << 1);
            Entry[] entries = bucket;
            bucket = new Entry[newBucketSize];
            bucketSize = 0;
            // TODO : 새로운 버킷이 할당되면 노드의 해시를 재계산하여 다시 삽입한다.
            for (Entry entry : entries) {
                if (entry != null && !entry.isDeleted) {
                    putValue(entry.key, entry.value);
                }
            }
        }
    }

    public void printHashTable() {
        System.out.println("-----Linear----");
        for (int i = 0; i < bucket.length; i++) {
            if (null != bucket[i] && bucket[i].isDeleted) {
                System.out.printf("| %d | %s\n", i, "null(dummy)");
            } else if (null != bucket[i]) {
                System.out.printf("| %d | %s\n", i, printNode(bucket[i]));
            } else {
                System.out.printf("| %d | %s\n", i, "null");
            }
        }
        System.out.println("---------------");
    }

    private String printNode(Entry entry) {
        StringBuilder builder = new StringBuilder();
        int hash = secondaryHash(entry.key);
        builder.append("(").append(entry.key).append(",").append(entry.value)
               .append(",").append(hash).append(")");
        return builder.toString();
    }

}
