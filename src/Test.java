import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test SortedArrayList
 *
 * @author Chris Louie
 */

public class Test {
    public static void main(String[] args) throws Exception {

        // constructor for sorted array list test
        SortedList<String> arr = new SortedArrayList<>();

        // Requirement 1: Empty at start

        System.out.println("This number should be zero == "+arr.size());

        // Requirement 2
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");

        System.out.println("Array looks like: " + arr);
        // Requirement 3, 4 & 5
        System.out.println("Getting : "+arr.get(0));
        System.out.println("Removing : "+arr.remove(0));

        // constructor for linked list test
        SortedList<Integer> arr1 = new SortedLinkedList<>();

        System.out.println("This number should be zero == "+arr1.size());

        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        // Requirement 3, 4 & 5
        System.out.println("Getting : " + arr.get(0));
        System.out.println("Removing : " + arr.remove(0));
    }
}
