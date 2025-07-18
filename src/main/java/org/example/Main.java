package org.example;

public class Main {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        try {
            linkedHashMap.put("One", 1);
            linkedHashMap.put("Two", 2);
            linkedHashMap.put("Three", 3);
            linkedHashMap.put("Four", 4);
            linkedHashMap.put("Five", 5);
            linkedHashMap.put("Six", 6);
            linkedHashMap.put("Seven", 7);

            // Update existing keys value
            linkedHashMap.put("One", 11);

            // Test retrieval
            System.out.println("\nGet 'Two': " + linkedHashMap.get("Two"));
            System.out.println("Get 'Four': " + linkedHashMap.get("Four"));
            System.out.println("Get 'Eight': " + linkedHashMap.get("Eight"));

            // Test containsKey
            System.out.println("\nContains 'One': " + linkedHashMap.containsKey("One"));
            System.out.println("Contains 'Three': " + linkedHashMap.containsKey("Three"));
            System.out.println("Contains 'Four': " + linkedHashMap.containsKey("Four"));
            System.out.println("Contains 'Eight': " + linkedHashMap.containsKey("Eight"));

            // Test removal
            System.out.println("\nRemove 'Two': " + linkedHashMap.remove("Two"));
            System.out.println("Remove 'Ten': " + linkedHashMap.remove("Ten"));

            // Print current state of the LinkedHashMap
            System.out.println("\nCurrent Map (insertion order): " + linkedHashMap.toString());

            // Clear the map
            linkedHashMap.clear();

            // Print after clearing
            System.out.println("\nMap after clear: " + linkedHashMap.toString());
            

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
