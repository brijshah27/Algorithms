package datastructures.stack;

// Stack implementation using array for type int.
public class IntStack {

    private int[] stack;
    private int pos = 0;

    // maxSize is the maximum number of items
    // that can be in the queue at any given time
    public IntStack(int maxSize) {
        stack = new int[maxSize];
    }

    // Returns the number of elements inside the stack
    public int size() {
        return pos;
    }

    // Returns true if stack is empty, false otherwise
    public boolean isEmpty(){
        return pos == 0;
    }

    // Returns the element at the top of the stack
    public int peek(){
        return stack[pos-1];
    }

    // Add an element to the top of the stack
    public void push(int value) {
        stack[pos++] = value;
    }

    // Make sure you check that the stack is not empty before calling pop!
    public int pop() {
        return stack[--pos];
    }

    // Example usage
    public static void main(String[] args) {

        IntStack s = new IntStack(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop()); // 5
        System.out.println(s.pop()); // 4
        System.out.println(s.pop()); // 3

        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) System.out.println(s.pop());

    }

}
