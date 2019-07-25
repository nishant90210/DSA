package ALGO;

public class HashTableImplementation {

    /* In this simple implementation, we use an array of linked lists and a hash code function.
    To insert a key(which might be a string or essentially any other data type) and value,*/

    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
    //First Creating the LinkedList
    public static class HashEntry {

        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HashEntry{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    //Now HashTable Implementation
    // 1.) First, compute the key's hash code, which will usually be an int or long.
    // 2.) Then, map the hash code to an index in the array. This could be done with something like hash (key)
    //     % array_length. Two different hash codes could, of course, map to the same index.
    // 3.) At this index, there is a linked list of keys and values. Store the key and value in this index. We must use a
    //     linked list because of collisions: you could have two different keys with the same hash code, or two different
    //     hash codes that map to the same index.

    private static int INITIAL_SIZE = 16;
    private HashEntry[] entries = new HashEntry[INITIAL_SIZE];

    // PUT Method
    public synchronized void put(String key, String value){

        if (value == null) {
            throw new NullPointerException();
        }
        int hash = getHash(key);
        final HashEntry hashEntry = new HashEntry(key, value);

        if(entries[hash] == null) {
            entries[hash] = hashEntry;
        }
        // If there is already an entry at current hash position,
        // add entry to the linked list.
        else {
            HashEntry temp = entries[hash];
            while (temp.next != null){
               temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }

    public String get(String key) {

        int hash = getHash(key);
        if (entries[hash] != null){
            HashEntry temp = entries[hash];
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
        HashTableImplementation hashTable = new HashTableImplementation();
        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }
        hashTable.put("20", "NIK");
//        hashTable.put("1", "Nishant");
//        hashTable.put("2", "Himani");
//        hashTable.put("3", "Nik");
//        hashTable.put("3", "Nika");
//        hashTable.put("1", "Him");

        // Print the HashTable structure
        log("****   HashTable  ***");
        log(hashTable.toString());
        log("\nValue for key(20) : " + hashTable.get("20") );
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

    private int getHash(String key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }
}