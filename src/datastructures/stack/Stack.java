package datastructures.stack;

import datastructures.linkedlist.DoublyLinkedList;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    DoublyLinkedList<T> list = new DoublyLinkedList();

    // Return the number of elements in the stack
    public int size() {
        return list.size();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T elem){
        list.addLast(elem);
    }

    // Pop an element off the stack
    // Throws an error is the stack is empty
    public T pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.deleteLast();
    }

    // Peek the top of the stack without removing an element
    // Throws an exception if the stack is empty
    public T peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.peekLast();
    }

    // Allow users to iterate through the stack using an iterator
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
