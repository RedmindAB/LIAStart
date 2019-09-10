package se.redmind.liastart.binarysearch;

import java.util.Arrays;

public interface BinarySearch {

    /**
     * first version I use javas default binarysearch() method
     * this is an easy method
     * @param key for search
     * @param values for the searching source
     * @return found index or -1 for out of bound
     */
    int chop(int key, int[] values);
	
}
