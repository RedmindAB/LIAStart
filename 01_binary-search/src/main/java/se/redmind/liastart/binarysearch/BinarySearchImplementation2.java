package se.redmind.liastart.binarysearch;

public class BinarySearchImplementation2 implements BinarySearch {

    public int chop(int key, int[] values) {
        int low = 0;
        int high = values.length - 1;
        int index;

        while (high >= low) {
            index = (high + low) / 2;
            if (values[index] == key) {
                return index;
            } else if (values[index] < key) {
                low = index + 1;
            } else high = index - 1;
        }
        return -1;

    }
}
