package se.redmind.liastart.binarysearch;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch search = new BinarySearch() {
        public int chop(int key, int[] values) {

            Arrays.sort(values);
            int result = Arrays.binarySearch(values, key);
            if (result <= -1) {
                return -1;
            } else {
                return result;
            }
        }
    };

    @Test
    public void test() {
		assertEquals(-1, chop(3, new int[] {}));
		assertEquals(-1, chop(3, new int[] { 1 }));
		assertEquals(0, chop(1, new int[] { 1 }));

		assertEquals(0, chop(1, new int[] { 1, 3, 5 }));
		assertEquals(1, chop(3, new int[] { 1, 3, 5 }));
		assertEquals(2, chop(5, new int[] { 1, 3, 5 }));
		assertEquals(-1, chop(0, new int[] { 1, 3, 5 }));
		assertEquals(-1, chop(2, new int[] { 1, 3, 5 }));
		assertEquals(-1, chop(4, new int[] { 1, 3, 5 }));
		assertEquals(-1, chop(6, new int[] { 1, 3, 5 }));

		assertEquals(0, chop(1, new int[] { 1, 3, 5, 7 }));
		assertEquals(1, chop(3, new int[] { 1, 3, 5, 7 }));
		assertEquals(2, chop(5, new int[] { 1, 3, 5, 7 }));
		assertEquals(3, chop(7, new int[] { 1, 3, 5, 7 }));
		assertEquals(-1, chop(0, new int[] { 1, 3, 5, 7 }));
		assertEquals(-1, chop(2, new int[] { 1, 3, 5, 7 }));
		assertEquals(-1, chop(4, new int[] { 1, 3, 5, 7 }));
		assertEquals(-1, chop(6, new int[] { 1, 3, 5, 7 }));
		assertEquals(-1, chop(8, new int[] { 1, 3, 5, 7 }));
    }

    private int chop(int key, int[] values) {
        return search.chop(key, values);
    }

}
