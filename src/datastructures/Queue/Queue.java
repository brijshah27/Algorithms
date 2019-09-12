package datastructures.Queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {
    private LinkedList<T> linkedList = new LinkedList<T>();

    public void Queue(){}

    public void Queue(T ele){
        linkedList.addFirst(ele);
    }

    // Return the size of the queue
    public int size() {
        return linkedList.size();
    }

    // Returns whether or not the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Peek the element at the front of the queue
    public T peek(){
      if(isEmpty()) throw new RuntimeException("Queue is empty");
      return linkedList.peekFirst();
    }

    // Poll an element from the front of the queue
    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return linkedList.removeFirst();
    }

    // Add an element to the back of the queue
    public void offer(T elem) {
        linkedList.addLast(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
