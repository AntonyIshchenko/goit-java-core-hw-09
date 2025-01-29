package task5;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> countries = new MyHashMap<>();
        System.out.println("countries = " + countries + " new size=" + countries.size());

        countries.put("Ukraine", "Kiev");
        countries.put("USA", "Washington");
        countries.put("England", "London");
        countries.put("Spain", "Madrid");

        System.out.println("countries = " + countries + " new size=" + countries.size());

        System.out.println("countries Spain = " + countries.get("Spain"));
        System.out.println("countries France = " + countries.get("France"));

        countries.put("England", "Liverpool");
        System.out.println("countries change England = " + countries + " new size=" + countries.size());

        String oldValue = countries.remove("Portugal");
        System.out.println("remove(Portugal) value = " + oldValue + " countries " + countries + " new size=" + countries.size());

        oldValue = countries.remove("USA");
        System.out.println("remove(USA) value = " + oldValue + " countries " + countries + " new size=" + countries.size());

        oldValue = countries.remove("England");
        System.out.println("remove(England) value = " + oldValue + " countries " + countries + " new size=" + countries.size());

        countries.clear();
        System.out.println("countries after clear() = " + countries + " new size=" + countries.size());
    }
}
