package org.example;

public class Main {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        try {
            linkedHashMap.put("One", 1);
            linkedHashMap.put("Two", 2);
            linkedHashMap.put("Three", 3);
            
            // Update existing keys value
            linkedHashMap.put("One", 11);

            // Test retrieval
            System.out.println("\nGet 'Two': " + linkedHashMap.get("Two"));
            System.out.println("Get 'Four': " + linkedHashMap.get("Four"));

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
