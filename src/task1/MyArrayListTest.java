package task1;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("00");
        stringList.add("01");
        stringList.add("02");

        System.out.println("StringList = " + stringList);
        System.out.println("StringList.size() = " + stringList.size());
        System.out.println("stringList.get(1) = " + stringList.get(1));
//        System.out.println("stringList.get(10) = " + stringList.get(10));

        stringList.clear();
        System.out.println("StringList after clear() = " + stringList);


        MyArrayList<Integer> intList = new MyArrayList<>();

        intList.remove(0);

        for (int i=0; i<15; i++){
            intList.add(i);
        }
        System.out.println("IntList = " + intList);

//        intList.remove(14);
//        intList.remove(0);
//        intList.remove(5);
//        intList.remove(15);

        for (int i=0; i<15; i++){
            intList.remove(0);
        }

        System.out.println("intList after remove() = " + intList);
    }
}
