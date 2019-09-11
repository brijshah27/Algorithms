package datastructures.linkedlist;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * Clear linked list.
     * Traverse trough whole list, assign next, data to be null for each node.
     * Make size default (0)
     */
    public void clear(){
        Node<T> trav = this.head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.next = null;
            trav.data = null;
            trav = next;
        }

        this.size = 0;
        this.head = null;
    }

    // Return size of the linked list.
    public int size(){
        return this.size;
    }

    // Return true if linked list is empty, false otherwise.
    public boolean isEmpty(){
        return this.size == 0;
    }


    // Add an element to the end of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    /**
     * Add element at the end of the linked list.
     * @param elem element to be inserted.
     */
    public void addLast(T elem){
        Node<T> newNode = new Node<T>(elem, null);

        // if list is empty new element node is the only node in the list.
        if(isEmpty()){
            this.head = newNode;
        }else{
            // if list has nodes, the last node has to be new node and existing last node has to be updated.
            Node<T> traversal = this.head;

            while(traversal.next != null){
                traversal = traversal.next;
            }
            traversal.next = newNode;
        }

        // increase size for new node inserted.
        this.size++;
    }

    /**
     * Insert element at the beginning of the linked list.
     * @param elem element to be inserted
     */
    public void addFirst(T elem){

        Node<T> newNode = new Node<T>(elem, null);
        // if list is empty new element node is the only node in the list.
        if(isEmpty()){
            this.head = new Node<T>(elem, null);
        }else{
            // if list has nodes, the new node has to be head and existing head has to be updated.
            newNode.next = this.head;
            this.head = newNode;
        }

        // increase size for new node inserted.
        this.size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return this.head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        Node<T> trav = this.head;

        while(trav.next != null){
            trav = trav.next;
        }
        return trav.data;
    }

    /**
     * Delete the first node of the list.
     * @return T data of the node deleted or null
     */
    public T deleteFirst(){

        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = this.head.data;
        this.head = this.head.next;
        --this.size;

        // Return the data that was at the first node we just removed
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
