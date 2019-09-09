package datastructures.dynamicarray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {

    private T[] staticArray;
    private int len = 0;
    private int capacity = 0;

    public void Array(){
        Array(16);
    }

    public void Array(int capacity){
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        staticArray = (T[]) new Object[capacity];
    }

    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        for(int i=0; i<len; i++){
            staticArray[i] =  null;
        }
        len = 0;
    }

    public T get(int index){
        return staticArray[index];
    }

    public void add(T ele){
        if(len+1 >= capacity){
            if(capacity==0) capacity =1;
            else capacity *= 2;

            T[] newStaticArray = (T[]) new Object[capacity];
            for(int i=0; i< len; i++){
                newStaticArray[i] = staticArray [i];
            }
            staticArray = newStaticArray;
            staticArray[len++] = ele;
        }
    }

    public T removeAt(int remove_index){
        if(remove_index >= len || remove_index<0) throw new IndexOutOfBoundsException();
        T remove_element = staticArray[remove_index];

        T[] newStaticArray = (T[]) new Object[len-1];
        for (int i = 0, j = 0; i < len; i++, j++)
        {
            if (i == remove_index) j--; // Skip over remove_index by fixing j temporarily
            else newStaticArray[j] = staticArray[i];
        }

        staticArray = newStaticArray;
        capacity = len--;
        return remove_element;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (staticArray[i] == null) return i;
            } else {
                if (obj.equals(staticArray[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return staticArray[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(staticArray[i] + ", ");
            return sb.append(staticArray[len - 1] + "]").toString();
        }
    }
}
