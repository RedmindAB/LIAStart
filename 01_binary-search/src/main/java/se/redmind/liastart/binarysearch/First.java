package se.redmind.liastart.binarysearch;

public class First implements BinarySearch {

    public int chop(int key, int[] values) {

        int start = 0;
        int end = values.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (values[mid] == key) {
                return mid;
            }

            if (key < values[mid]) {
                end = mid - 1;
                
            } else if (key > values[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}