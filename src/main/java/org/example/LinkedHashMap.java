package org.example;

import java.util.Objects;

/**
 * A generic implementation of a LinkedHashMap
 */
public class LinkedHashMap<K, V> {

    // The Nodes stored in the LinkedHashMap
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> hashNext;
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
        // Creates an array of Node objects (Node<K, V>)
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

    /**
     * Inserts a new key-value pair into the LinkedHashMap.
     * If the key already exists, its value is updated.
     * Otherwise, a new node is created and inserted into the appropriate hash
     * bucket
     * 
     * @param key   The key to insert or update
     * @param value The value associated with the key
     */
    public void put(K key, V value) {

        // Calculate bucket index by hashing the key
        int index = hash(key);

        // Start at heade node of the bucket linked list
        Node<K, V> currentNode = table[index];

        // Traverse through the linked hash map to determine if the key already exists
        while (currentNode != null) {
            // If found, update and return
            if (Objects.equals(currentNode.key, key)) {
                currentNode.value = value;
                return;
            }
            // Otherwise move to the next node
            currentNode = currentNode.hashNext;
        }

        // If key not found, create new node
        Node<K, V> newNode = new Node<>(key, value);

        // Insert new node at head of of bucket chain / linked list
        newNode.hashNext = table[index];
        table[index] = newNode;

        // Maintain insertion order by adding to the end of the doubly linked list
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Retrieves the value associated with the given key
     * 
     * @param key The key to look up
     * @return The value associated with the key, or null if the key does not exist
     */
    public V get(K key) {
        // Calculate bucket index by hashing the key
        // Store the head node of the bucket linked list
        int index = hash(key);
        Node<K, V> currentNode = table[index];

        // Traverse through the linked hash map to find the key
        while (currentNode != null) {
            if (Objects.equals(currentNode.key, key)) {
                return currentNode.value;
            }
            currentNode = currentNode.hashNext;
        }
        // If key not found, return null
        return null;
    }

    /**
     * Checks if the provided key exists in the LinkedHashMap
     * 
     * @param key The key to check for
     * @return true if the key exists, false otherwise
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Returns the number of key-value pairs in the LinkedHashMap
     * 
     * @return The size of the LinkedHashMap
     */
    public int size() {
        return size;
    }

    /**
     * Removes an entry from the LinkedHashMap given the key
     * 
     * @param key The key of the key-value pair to remove
     * @return The value associated with the removed key, or null if the key does not exist
     */
    public V remove(K key) {
        // Calculate bucket index by hashing the key
        int index = hash(key);

        // Get first node in the bucket linked list
        Node<K, V> currentNode = table[index];
        Node<K, V> previousNode = null;

        // Traverse through the hash bucket linked list to find the target key
        while (currentNode != null) {
            
            // Check if the current node's key matches the key to be removed
            if (Objects.equals(currentNode.key, key)) {

                // If found, check if the previous node is null

                // Check if this is the first node in the bucket
                if (previousNode == null) {
                    // If so, set buckets head to the next node
                    table[index] = currentNode.hashNext;
                } else {
                    // Otherwise, bypass the current node in the chain
                    previousNode.hashNext = currentNode.hashNext;
                }

                // If the node has a previous node in insertion order
                if (currentNode.prev != null) {
                    // Update previous node's next reference
                    currentNode.prev.next = currentNode.next;
                } else {
                    // If it's the head of the insertion order list, move head forward
                    head = currentNode.next;
                }

                // Check if node has a next node in insertion order
                if (currentNode.next != null) {
                    // Update next node's previous reference
                    currentNode.next.prev = currentNode.prev;
                } else {
                    // If it's the tail of the insertion order list, move tail backward
                    tail = currentNode.prev;
                }
                size--;
                return currentNode.value;
            }
            // Move to next node in the bucket
            previousNode = currentNode;
            currentNode = currentNode.hashNext;
        }
        return null;
    }

    /**
     * Return a string representation of the LinkedHashMap in insertion order
     * 
     * @return A string representation of the LinkedHashMap
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Node<K, V> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.key).append("=").append(currentNode.value);
            if (currentNode.next != null) sb.append(", ");
            currentNode = currentNode.next;
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Prints all key-value pairs in the LinkedHashMap in insertion order
     */
    public void print() {
        Node<K, V> current = head;
        while (current != null) {
            System.out.println("Key: " + current.key + ", Value: " + current.value);
            current = current.next;
        }
    }

}
