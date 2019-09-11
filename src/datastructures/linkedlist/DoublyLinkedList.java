package datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * Clear linked list.
     * Traverse trough whole list, assign next, prev, data to be null for each node.
     * Make size default (0)
     */
    public void clear(){
        Node<T> traversal = this.head;
        while(traversal != null){
            Node<T> next = traversal.next;
            traversal.prev = null;
            traversal.next = null;
            traversal.data = null;
            traversal = next;
        }

        this.size = 0;
        this.head = this.tail = null;
    }

    // Return size of the linked list.
    public int size(){
        return this.size;
    }

    // Return true if linked list is empty, false otherwise.
    public boolean isEmpty(){
        return this.size == 0;
    }


    // Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    /**
     * Insert element at the beginning of the linked list.
     * @param elem element to be inserted
     */
    public void addFirst(T elem){

        // if list is empty new element node is the only node in the list.
        if(isEmpty()){
            this.head = this.tail= new Node<T>(elem, null, null);
        }else{
            // if list has nodes, the new node has to be head and existing head has to be updated.
            this.head.prev = new Node<T>(elem, null, this.head);
            this.head = head.prev;
        }

        // increase size for new node inserted.
        this.size++;
    }

    /**
     * Add element at the end of the linked list.
     * @param elem element to be inserted.
     */
    public void addLast(T elem){
        // if list is empty new element node is the only node in the list.
        if(isEmpty()){
            this.head = this.tail= new Node<T>(elem, null, null);
        }else{
            // if list has nodes, the last node has to be new node and existing last node has to be updated.
            Node<T> traversal = this.head;
            this.tail.next = new Node<T>(elem, tail, null);
            this.tail = this.tail.next;
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
        return this.tail.data;
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

        // If the list is empty set the tail to null
        if (isEmpty()) tail = null;

        // Do a memory cleanup of the previous node
        else this.head.prev = null;

        // Return the data that was at the first node we just removed
        return data;
    }


    /**
     * Delete the last node of the list.
     * @return T data of the node deleted or null
     */
    public T deleteLast(){

        // Can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = this.tail.data;
        this.tail = this.tail.prev;
        --this.size;

        // If the list is empty set the tail to null
        if (isEmpty()) head = null;

        // Do a memory cleanup of the previous node
        else this.tail.next = null;

        // Return the data that was at the first node we just removed
        return data;
    }

    /**
     * Delete node at given index.
     * @param index index of the node to be deleted
     * @return data of the node deleted
     */
    public T deleteAt(int index){
        if(index < 0 || index >= this.size) throw new IllegalArgumentException("Invalid index");
        int i;
        Node<T> trav;

        // Search from the front of the list
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) trav = trav.next;

            // Search from the back of the list
        } else for (i = size - 1, trav = tail; i != index; i--) trav = trav.prev;

        remove(trav);

        return trav.data;
    }

    /**
     * Remove particular value from lined list.
     * @param obj object to be removed
     * @return boolean indicating outcome of the operation
     */
    public boolean remove(Object obj) {

        Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // Search for non null object
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /**
     * Find the index of a particular value in the linked list, O(n)
     * @param obj object for which index needs be found
     * @return data of the object found
     */
    public int indexOf(Object obj) {

        int index = 0;
        Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (; trav != null; trav = trav.next, index++) if (trav.data == null) return index;

            // Search for non null object
        } else for (; trav != null; trav = trav.next, index++) if (obj.equals(trav.data)) return index;

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
