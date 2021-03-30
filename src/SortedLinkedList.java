import java.util.ArrayList;
import java.util.Iterator;

public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T> {
    // data members
    // might change head to protected
    private class Node<T>{
        T data;
        Node<T> next;

        private Node(T i) {
            data = i;
            next = null;
        }
    }

    protected Node<T> head;
    protected int size;

    // constructor for the sortedlinkedlist
    protected SortedLinkedList() {
        head = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    // add function for linkedlist similar to insert
    @Override
    public boolean add(T item) {
        if (head == null) {
            head = new Node(item);
            size++;
            return true;
        }
        Node prev = head;
        for (int i=0;i<size;i++){
            prev = prev.next;
        }
        Node next = new Node(item);
        prev.next = next;
        size++;
        return true;
    }
    // second add function to add at position
    public void add(int pos, T item) {
        if (pos==0) {
            Node next = new Node(item);
            next.next = head;
            head = next;
            size++;
        }
        else {
            Node prev = head;
            for (int i=0;i<pos-1;i++){
                prev = prev.next;
            }
            Node next = new Node(item);
            next.next = prev.next;
            prev.next = next;
            size++;
        }
    }
    // remove function for linked list
    @Override
    public T remove(int pos) throws Exception {
        if (pos < 0 || pos >= size){
            throw new Exception("Invalid Position");
        }
        if (pos==0){
            Node node = head;
            head = head.next;
            --size;
            return (T) node.data;
        } else {
            Node prev = head;
            for (int i=0;i<pos-1;i++){
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            --size;
            return (T) node.data;
        }
    }
    // get function for linked list
    @Override
    public T get(int pos) throws Exception {
        if (pos < 0 || pos >= size) {
            throw new Exception("Invalid Position");
        }
        if (pos == 0) {
            Node node = head;
            head = head.next;
            return (T) node.data;
        }
        else {
            Node prev = head;
            for (int i=0;i<pos;i++){
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            return (T) node.data;
        }
    }
}
