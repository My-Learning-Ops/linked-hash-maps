
import java.util.Objects;

/**
 * A generic implementation of a LinkedHashMap
 */
public class LinkedHashMap<K, V> {

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
     * Inserts a new key-value pair into the LinkedHashMap
     * 
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> currentNode = table[index];

        // Traverse through the linked hash map to determine if the key already exists
        while (currentNode != null) {
            if (Objects.equals(currentNode.key, key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }

        // If key not found, create new node and insert it at head
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];

        if (table[index] != null)
            table[index].prev = newNode;

        table[index] = newNode;

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
