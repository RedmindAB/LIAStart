package se.redmind.liastart.binarysearch;

public class Second implements BinarySearch {

    public int chop(int key, int[] values) {
        int start = 0;
        int end = values.length - 1;
        return recursion(key, values, start, end);
    }

    private int recursion(int key, int[] values, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (values[mid] == key) {
            return mid;

        } else if (key < values[mid]) {
            return recursion(key, values, start, mid - 1);

        } else {
            return recursion(key, values, mid + 1, end);
        }
    }
}
