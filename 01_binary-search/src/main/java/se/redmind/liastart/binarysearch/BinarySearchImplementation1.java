package se.redmind.liastart.binarysearch;

public class BinarySearchImplementation1 implements BinarySearch {

    public int chop(int key, int[] values) {
        return chopChop(values, key, 0, values.length - 1);
    }

    private int chopChop(int[] values, int key, int low, int high) {
        int index = (high + low) / 2;

        if (high >= low) {
            if (values[index] == key) {
                return index;
            }
            if (values[index] < key) {
                return chopChop(values, key, index + 1, high);
            }
            return chopChop(values, key, low, index - 1);
        }
        return -1;
    }
}
