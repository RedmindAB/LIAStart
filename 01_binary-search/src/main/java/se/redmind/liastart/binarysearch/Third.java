package se.redmind.liastart.binarysearch;

import java.util.Arrays;

public class Third implements BinarySearch {

    public int chop(int key, int[] values) {
        
        int result = Arrays.binarySearch(values, key);
        if (result < 0) {
            result = -1;
        }
        
        return result;
    }
}
