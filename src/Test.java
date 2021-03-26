/**
 * Test SortedArrayList
 *
 * @author Chris Louie
 */

public class Test {
    public static void main(String[] args) throws Exception {

        // constructor
        SortedList<String> arr = new SortedArrayList<>();

        // Requirement 1: Empty at start
        System.out.println(arr.size());

        // Requirement 2
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");

        // Requirement 3, 4 & 5
        System.out.println(arr.get(0));
        System.out.println(arr.remove(0));
    }
}
