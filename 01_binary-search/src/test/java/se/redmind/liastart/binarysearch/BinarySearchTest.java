package se.redmind.liastart.binarysearch;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch search = new BinarySearch() {

        public int chop(int key, int[] values) {

            int binSearch = Arrays.binarySearch(values, key);

            int result = (binSearch <= -1) ? -1 : binSearch;

            return result;
        }

//        public int chop(int key, int[] values) {
//
//            int start = 0;
//            int end = values.length - 1;
//            int mid;
//            
//            while (start <= end) {
//
//                mid = (start + end) / 2;
//                
//                if (key > values[mid]) {
//                    start = mid + 1;
//                    System.out.println("Checking upper half.");
//                    
//                } else if (key == values[mid]) {
//                    System.out.println("Target exists! Target is at index: " + mid);
//                    return mid;
//                } else {
//                    end = mid - 1;
//                    System.out.println("Checking lower half.");
//                }
//            }
//
//            return -1;
//        }
    };

    @Test
    public void test() {
        assertEquals(-1, chop(3, new int[]{}));
        assertEquals(-1, chop(3, new int[]{1}));
        assertEquals(0, chop(1, new int[]{1}));

        assertEquals(0, chop(1, new int[]{1, 3, 5}));
        assertEquals(1, chop(3, new int[]{1, 3, 5}));
        assertEquals(2, chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, chop(6, new int[]{1, 3, 5}));

        assertEquals(0, chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(8, new int[]{1, 3, 5, 7}));
    }

    private int chop(int key, int[] values) {
        return search.chop(key, values);
    }

}
