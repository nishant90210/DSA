package LRU;

import java.util.HashMap;

public class HashMapWithDoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    HashMap<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    public HashMapWithDoublyLinkedList(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public void addToHead(Node node){

        if (cache.size() == 0){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void deleteNode(Node node){

        //if node to be deleted is the first node
        if (head == node){
            head = node.next;
        }
        //if node to be deleted is the last node
        if (tail == node){
            tail = node.prev;
        }
        //if node to be deleted is not the first or the last
        if (node.prev != null){
            node.prev.next = node.next;
        }
        if (node.next != null){
            node.next.prev = node.prev;
        }
    }

    public void look(int key) {

        if (cache.containsKey(key)){
            Node keyNode = cache.get(key);
            deleteNode(keyNode);
        }else {
            if(cache.size() == capacity){
                //cache is full, delete the last entry
                int tailData = tail.data;
                deleteNode(tail);
                cache.remove(tailData);
            }
        }
        // add it to cache
        Node newNode = new Node(key);
        addToHead(newNode);
        cache.put(key, newNode);
        System.out.println("Item accessed: " + key);
        printCache();
    }

    public void printCache(){
        System.out.print("Cache : ");
        Node start = head;
        while(start!=null){
            System.out.print(start.data + " ");
            start = start.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int capacity = 4;
        HashMapWithDoublyLinkedList lru = new HashMapWithDoublyLinkedList(capacity);
        lru.look(1);
        lru.look(2);
        lru.look(1);
        lru.look(3);
        lru.look(4);
        lru.look(3);
        lru.look(5);
        lru.look(4);
        lru.look(6);
    }
}
