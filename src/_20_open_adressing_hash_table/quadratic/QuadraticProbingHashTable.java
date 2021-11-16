package _20_open_adressing_hash_table.quadratic;

public class QuadraticProbingHashTable {
    // 버킷으로 할당할 수 있는 최대 크기
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    // 버킷의 엔트리가 75%를 넘으면 버킷의 크기를 늘린다.
    private static final float ROAD_FACTOR_THRESHOLD = 0.75F;

    private Entry[] bucket;
    private int bucketSize;
    private final Entry dummyNull = new Entry(null, null, true);

    public QuadraticProbingHashTable() {
        this(16);
    }

    public QuadraticProbingHashTable(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("정상적인 해시 테이블의 크기를 정해주세요");
        }
        bucket = new Entry[tableSizeFor(capacity)];
    }

    private int tableSizeFor(int capacitor) {
        // TODO : 2의 제곱수로 bucket 사이즈를 상향식으로 보정한다. (예: 100 -> 128)
        int n = capacitor - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 15;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private int secondaryHash(Object key) {
        /**
         * 보조 해시 함수 : h'(k) -> {0, 1, 2, ..., m-1}
         * 해시값을 최대한 흩어 놓기 위해 앞의 16비트를 옮겨 기존의 해시값과 XOR 연산을 먼저 한 후
         * bucket 크기 만큼의 범위에 들어가게 하기 위해 비트 연산을 한다.
         *
         * 만약에 최적화를 한다면 h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)로
         * 연산된 값을 노드에 저장하여 재이용하면 된다.
         */

        int h;
        h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        return h & (bucket.length - 1);
    }

    private int hash(Object key, int i) {
        /**
         * h(key, i) : (h'(k) + (c1 * i) + (c2 * i^2)) % m
         */
        int c1 = 2;
        int c2 = 2;
        int m = bucket.length;
        return ((secondaryHash(key) + i) + (c1 * i) + (c2 * i * i)) % m;
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
         * T[h'(k)]부터 T[m-1]까지 동일한 키가 있거나 빈공간이 있는지 탐색한다.
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
            } else if (bucket[bucketIndex] == null ||
                       (bucket[bucketIndex] != null && bucket[bucketIndex].isDeleted)) {
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
         * 조사된 버킷의 위치에 저장된 값이 null이 아니고, 이미 동일한 키가 존재하면 값을 덮어 쓴다.
         * null인 경우 해당 자리에 키와 값을 저장한다.
         */
        int index = insertProbing(key);
        if (bucket[index] != null && key.equals(bucket[index].key)) {
            // 버킷에 동일한 키가 존재 시
            bucket[index].value = value;
        } else if (bucket[index] == null ||
                   (bucket[index] != null && bucket[index].isDeleted)) {
            // bucket[index]가 null이거나 Dummy null 엔트리 존재 시
            bucket[index] = new Entry(key, value, false);
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
        int bucketIndex = probing(key);
        int removedIndex = -1;
        if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
            // TODO : Dummy null 엔트리를 삽입한다.
            bucket[bucketIndex] = this.dummyNull;
            removedIndex = bucketIndex;
            --bucketSize;
        }

        // TODO : 끌어당기기 로직
        if (removedIndex != -1) {
            int nullIndex = removedIndex;
            for (int i = 0; i < bucket.length; i++) {
                int moveIndex = (i + removedIndex) % bucket.length;
                // TODO : Linear Probing과 다르게 nullIndex가 동일한 것만 당겨온다.
                if (bucket[moveIndex] != null &&
                    !bucket[moveIndex].isDeleted &&
                    secondaryHash(bucket[moveIndex].key) == nullIndex) {
                    // bucket[moveIndex]가 null이 아니며
                    // Dummy null 엔트리도 아니고
                    // 해시값이 nullIndex 보다 작은 경우
                    bucket[nullIndex] = bucket[moveIndex];
                    bucket[moveIndex] = this.dummyNull;
                    nullIndex = moveIndex;
                }
            }
        }
     }

     private void resizeBucket() {
        // TODO : 적재율이 임계치를 넘으면 버킷의 크기를 늘린다.
        int prevBucketSize = bucket.length;
        if (prevBucketSize >= MAXIMUM_CAPACITY) {
            // TODO : 이미 최대 버킷 크기이면 크기를 늘릴 수 없다.
            return;
        }
        if (bucketSize * 1.0F / prevBucketSize > ROAD_FACTOR_THRESHOLD) {
            int newBucketSize = tableSizeFor(prevBucketSize << 1);
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
        System.out.println("---Quadratic---");
        for (int i = 0; i < bucket.length; i++) {
            if (null != bucket[i]) {
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

