package org.example;




public class LinkedHashMap<K, V> {

    // Node stored in the linked list
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node<K, V>[] table;
    private Node<K, V> head, tail;
    private int size = 0;

    // Constructs an empty LinkedHashMap with a default capacity
    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }
    
}
