package task3;

public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue<String> myQueue = new MyQueue<>();
        System.out.println("myQueue = " + myQueue + " new size=" + myQueue.size());

        String s = myQueue.peek();
        String p = myQueue.poll();

        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");

        System.out.println("myQueue = " + myQueue + " new size=" + myQueue.size());
        System.out.println("myQueue.peek() = " + myQueue.peek());

        myQueue.poll();
        myQueue.poll();

        System.out.println("myQueue after 2 poll()= " + myQueue + " new size = " + myQueue.size());

        myQueue.clear();
        System.out.println("myQueue after clear() = " + myQueue + " new size = " + myQueue.size());
    }
}
