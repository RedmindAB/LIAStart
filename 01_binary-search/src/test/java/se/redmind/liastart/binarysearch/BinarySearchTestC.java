package se.redmind.liastart.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTestC {

private BinarySearch search = new BinarySearch () {
	public int chop (int key, int[] values) {
		return -1;
	}
};

@Test
public void test () {
	assertEquals (-1, chop (3, new int[]{}));
	assertEquals (-1, chop (3, new int[]{1}));
	assertEquals (0, chop (1, new int[]{1}));
	assertEquals (0, chop (1, new int[]{1, 3, 5}));
	assertEquals (1, chop (3, new int[]{1, 3, 5}));
	assertEquals (2, chop (5, new int[]{1, 3, 5}));
	assertEquals (-1, chop (0, new int[]{1, 3, 5}));
	assertEquals (-1, chop (2, new int[]{1, 3, 5}));
	assertEquals (-1, chop (4, new int[]{1, 3, 5}));
	assertEquals (-1, chop (6, new int[]{1, 3, 5}));
	assertEquals (0, chop (1, new int[]{1, 3, 5, 7}));
	assertEquals (1, chop (3, new int[]{1, 3, 5, 7}));
	assertEquals (2, chop (5, new int[]{1, 3, 5, 7}));
	assertEquals (3, chop (7, new int[]{1, 3, 5, 7}));
	assertEquals (-1, chop (0, new int[]{1, 3, 5, 7}));
	assertEquals (-1, chop (2, new int[]{1, 3, 5, 7}));
	assertEquals (-1, chop (4, new int[]{1, 3, 5, 7}));
	assertEquals (-1, chop (6, new int[]{1, 3, 5, 7}));
	assertEquals (-1, chop (8, new int[]{1, 3, 5, 7}));
}

private int chop (int key, int[] values) {
	return recurseInt (key, values, 0, values.length - 1);
}

private int recurseInt (int key, int[] values, int low, int high) {
	
	while (low <= high) {
	
		int mid = low + (high - low) / 2;
	
		if (values[mid] == key) {
			return mid;
		}
		if (values[mid] > key) {
			return recurseInt (key, values, low, mid - 1);
		}
		return recurseInt (key, values, mid + 1, high);
	}
	return -1;
}

}