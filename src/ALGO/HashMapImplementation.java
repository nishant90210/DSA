package ALGO;

public class HashMapImplementation {

    // for better re-sizing is taken as 2^4
    private static final int INITIAL_SIZE = 16;
    private HashTableImplementation.HashEntry[] entries = new HashTableImplementation.HashEntry[INITIAL_SIZE];

    /**
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(String key, String value) {

        int hash = key.hashCode() % INITIAL_SIZE;
        HashTableImplementation.HashEntry entry = entries[hash];
        if (entry != null){
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if (entry.key.equals(key)){
                entry.value = value;
            }else {
                // Collision: insert new element at the end of list in the same bucket
                while (entry.next != null){
                    entry = entry.next;
                }
                HashTableImplementation.HashEntry entryInOldBucket = new HashTableImplementation.HashEntry(key, value);
                entry.next = entryInOldBucket;
            }
        }else {
            HashTableImplementation.HashEntry entryInNewBucket = new HashTableImplementation.HashEntry(key, value);
            entries[hash] = entryInNewBucket;
        }
    }

    public String get(String key) {

        int hash = getHash(key);
        if (entries[hash] != null){
            HashTableImplementation.HashEntry temp = entries[hash];
            // Check the entry linked list for match
            // for the given 'key'
            while (!temp.key.equals(key) && temp.next != null){
                temp = temp.next;
            }
            return temp.value;
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapImplementation myHashMap = new HashMapImplementation();

        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Gaurav", "SE");
        myHashMap.put("Awadh", "Nishant");

        String entry = myHashMap.get("Awadh");
        System.out.println(""+entry);
    }

    private int getHash(String key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }
}