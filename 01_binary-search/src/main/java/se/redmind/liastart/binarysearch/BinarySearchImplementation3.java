package se.redmind.liastart.binarysearch;

public class BinarySearchImplementation3 implements BinarySearch {

    public int chop(int key, int[] values) {
        int low = 0;
        int high = values.length - 1;
        int index;

        for (int i = 0; i < log2(values.length) + 1; i++) {
            index = (high + low) / 2;
            if (values[index] == key) {
                return index;
            } else if (values[index] < key) {
                low = index + 1;
            } else high = index - 1;
        }
        return -1;
    }

    private int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }


}
