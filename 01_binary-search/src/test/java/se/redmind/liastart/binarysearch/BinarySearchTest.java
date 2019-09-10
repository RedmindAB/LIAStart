package se.redmind.liastart.binarysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {

	private BinarySearch search = new BinarySearch() {

		public int chop(int key, int[] values) {
			int left = 0;
			int right = values.length - 1;
			while(left <= right){
				int mid = left + ((right - left) / 2);
				if(values[mid] == key){
					return mid;
				}
				else if(key < values[mid]){
					right = mid - 1;
				}
				else{
					left = mid + 1;
				}
			}
			return -1;
		}

	};

	private BinarySearch search2 = new BinarySearch() {
		public int chop(int key, int[] values) {
			for (int i = 0; i < values.length; i++)
				if (values[i] == key)
					return i;

			return -1;
		}
	};
	private BinarySearch search3 = new BinarySearch() {
		public int chop(int key, int[] values) {
			int index = Arrays.binarySearch(values, key);
			return (index < 0) ? -1 : index;
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
