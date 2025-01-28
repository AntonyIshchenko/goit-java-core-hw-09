package task2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("First");
        myList.add("Second");
        myList.add("Third");

        System.out.println("myList = " + myList + " new size=" + myList.size());
        System.out.println("myList.get(1) = " + myList.get(1));

        try {
            System.out.println("myList.get(11) = " + myList.get(11));
        } catch (Exception e) {
            System.out.println("TmyList.get(11) finished with error: " + e.toString());
        }

        try {
            myList.remove(5);
            System.out.println("myList.remove(5) = " + myList);
        } catch (Exception e) {
            System.out.println("TmyList.remove(5) finished with error: " + e.toString());
        }

        myList.remove(1);
        System.out.println("myList.remove(1) = " + myList + " new size = " + myList.size());

        myList.clear();
        System.out.println("myList after clear() = " + myList + " new size = " + myList.size());

    }
}


