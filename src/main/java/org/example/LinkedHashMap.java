package org.example;

/**
 * A generic implementation of a LinkedHashMap
 */
public class LinkedHashMap {

    // The Nodes stored in the LinkedHashMap
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        // Constructs a Node to be stored in the LinkedHashMap
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity = 16;
    private Node<K, V>[] table;
    private Node<K, V> head;
    private Node<K, V> tail;
    private int size = 0;

    // Constructs an empty LinkedHashMap with a default capacity
    public LinkedHashMap() {
        table = new Node[capacity];
    }

    /**
     * Calculates the hash code for a given key,
     * where the hash code represents which bucket (index) the key-value pair will
     * be stored in.
     * 
     * @param key The key to hash
     * @return The bucket index for the key
     */
    private int hash(K key) {
        return Math.abs(Objects.hashCode(key)) % capacity;
    }

}
