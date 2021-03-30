import java.lang.reflect.Array;
import java.util.ArrayList;

public class SortedArrayList<T extends Comparable<T>> implements SortedList<T> {
    protected T[] arr;
    protected int size;

    // constructor note: related problem abstract classes cannot be instantiated?
    public SortedArrayList() {
        arr = (T[]) new Comparable[10];
        size = 0;
    }
    // size function
    @Override
    public int size() {
        return size;
    }
    // grow array helper function from lecture adjusted for this assignment
    private void grow_array() {
        T[] arr2 = (T[]) new Comparable[size*=2];
        for (int i=0;i<size;i++) {
            arr2[i] =  arr[i];
        }
        arr = arr2;
    }
    // add function
    @Override
    public boolean add(T item) {
        // grow the array, default for all add functions
        if (size==arr.length){
            grow_array();
        }
        // if size is 0, add the item
        if (size==0) {
            arr[size++] = item;
            return true;
        }
        // ghetto way to sort through the array
        for (int i=size()-1;i>=0;i--) {
            if (arr[i].compareTo(item)<0) {
                arr[i+1] = item;
                arr[i] = arr[i];
                size++;
                return true;
            }
            else if (arr[i].compareTo(item)>=0) {
                arr[i+1] = arr[i];
                arr[i] = item;
                size++;
                return true;
            }
        }
        // i think we need this line at the end regardless
        return true;
    }
    // remove an item at the position, also modified method from the previous assignment
    @Override
    public T remove(int pos) throws Exception {
        if (pos < 0 || pos >= size){
            throw new Exception("Invalid Position");
        }
        //copy
        T item = arr[pos];
        for (int i=pos;i<size-1;i++){
            arr[i]=arr[i+1];
        }
        size-=1;
        return item;
    }
    // get item at position, modified method from previous assignment
    @Override
    public T get(int pos) throws Exception {
        if (pos < 0 || pos >= size){
             throw new Exception("Invalid Position");
        }
        return arr[pos];
    }
    // Override toString function for arrays
    @Override
    public String toString(){
        String result = "";
        for (int i=0;i<size;i++){
            result = result + arr[i] + "";
        }
        return result;
    }
}
