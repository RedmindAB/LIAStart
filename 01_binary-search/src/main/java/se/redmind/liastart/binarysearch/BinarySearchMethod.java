
package se.redmind.liastart.binarysearch;

import java.util.Arrays;


public class BinarySearchMethod implements BinarySearch {

    public int chop(int key, int[] values) {
        
        int result = Arrays.binarySearch(values, key);
        if (result >= 0){
            return result;
        }
        else
            return -1;
        
    }

}
