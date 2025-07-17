
public class Main {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        try {
            linkedHashMap.put("One", 1);
            linkedHashMap.put("Two", 2);
            linkedHashMap.put("Three", 3);
            linkedHashMap.put("One", 11);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
