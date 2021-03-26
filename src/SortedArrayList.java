import java.util.ArrayList;

public class SortedArrayList<T extends Comparable<T>> implements SortedList<T> {
    protected T[] arr;
    protected int size;

    // constructor note: related problem abstract classes cannot be instantiated?
    public SortedArrayList() {
        super();
        arr = (T[]) new Comparable[10];
        size = 0;
    }
    // size function
    @Override
    public int size(){
        return size;
    }
    // grow array helper function from lecture adjusted for this assignment
    private void grow_array() {
        T[] arr2 = (T[]) new Comparable[size*=2];
        for (int i=0;i<size;i++){
            arr2[i] =  arr[i];
        }
        arr = arr2;
    }
    // add function from lecture
    public void add(int pos, T item){
        if (size == arr.length){
            grow_array();
        }
        for (int i=size();i>pos;i--){
            arr[i] = arr[i-1];
        }
        arr[pos] = item;
        size++;
    }
    @Override
    public boolean add(T item){
        if (size==arr.length){
            grow_array();
        }
        add(size++,item);
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
}
