package _21_chaining_hash_table;

public class Main {
    public static void main(String[] args) {

        ChainingHashTable channingHashTable = new ChainingHashTable(4);
        channingHashTable.put("hi", 1);
        channingHashTable.put("hi2", 2);
        channingHashTable.put("hi3", 3);
        channingHashTable.put("hi4", 4);
        channingHashTable.put("hi5", 5);
        channingHashTable.put("hi6", 6);
        channingHashTable.put("hi7", 7);
        channingHashTable.put("hi8", 8);
        channingHashTable.put("hi9", 9);
        channingHashTable.put("hi10", 10);
        channingHashTable.put("hi11", 11);
        channingHashTable.put("hi12", 12);
        channingHashTable.put("hi13", 13);
        channingHashTable.put("hi14", 14);
        channingHashTable.put("hi15", 15);
        channingHashTable.put("hi16", 16);
        channingHashTable.put("hi17", 17);
        channingHashTable.put("hi18", 18);
        channingHashTable.put("hi19", 19);
        channingHashTable.put("hi20", 20);
        channingHashTable.printHashTable();

        System.out.println(channingHashTable.get("hi17"));
        channingHashTable.remove("hi17");
        channingHashTable.printHashTable();

    }
}
