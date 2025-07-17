package org.example;

import java.util.*;


// A generic implementation of a LinkedHashMap
public class LinkedHashMap<K, V> {

    // Node stored in the linked list
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        Node<K, V> after;
        Node<K, V> before;

        // Construct a Node with a key and value
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node<K, V>[] table;
    private Node<K, V> head, tail;
    private int size = 0;

    // Constructs an empty LinkedHashMap with a specified capacity
    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        // Generic array creation warning due to the creration
        // of a raw type array of Node objects
        // This is due to the the JVM erases type params at runtime
        this.table = new Node[capacity];
    }

    // Computes the hash code for a given key
    public int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Adds a key-value pair to the LinkedHashMap
    // If the key already exists, it updates the value
    public void put (K key, V value) {

        // Holds the index in the table where the key value pair will be stored
        int index = hash(key);
        Node<K, V> existingNode = table[index];

        // Check if the ke7y exists in the hash bucket
        while (existingNode != null) {
            if (existingNode.key.equals(key)) {
                // Update existing method
                existingNode.value = value; // Update existing value
                return;
            }
            existingNode = existingNode.next;
        }

        // If the key does not exist, create a new node
        Node<K, V> newNode = new Node<>(key, value);

        // Add the new node to the hash bucket
        newNode.next = table[index];
        table[index] = newNode;

        // Maintain order of insertion in the linked list
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.after = newNode;
            newNode.before = tail;
            tail = newNode;
        }
        size++;
    }



    
}
