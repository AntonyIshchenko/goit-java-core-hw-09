package task4;

public class MyStackTest {
    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack<>();
        System.out.println("myStack = " + myStack + " new size=" + myStack.size());

        String peek = myStack.peek();
        String pop = myStack.pop();

        myStack.push("First");
        myStack.push("Second");
        myStack.push("Third");
        myStack.push("Four");

        System.out.println("myStack = " + myStack + " new size=" + myStack.size());
        System.out.println("myStack.peek() = " + myStack.peek());

        myStack.pop();
        myStack.pop();

        System.out.println("myStack after 2 pop()= " + myStack + " new size = " + myStack.size());

        try {
            myStack.remove(5);
            System.out.println("myStack.remove(5) = " + myStack);
        } catch (Exception e) {
            System.out.println("myStack.remove(5) finished with error: " + e.toString());
        }

        myStack.remove(0);
        System.out.println("myStack.remove(0) = " + myStack + " new size = " + myStack.size());

        myStack.clear();
        System.out.println("myStack after clear() = " + myStack + " new size = " + myStack.size());
    }
}
