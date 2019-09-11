package se.redmind.liastart.binarysearch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinarySearchTestA {

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
	
	int low = 0;
	int high = values.length - 1;
	
	while (low <= high) {
		
		int mid = (low + high) / 2;
		
		if (values[mid] == key) {
			return mid;
		}
		else if (values[mid] < key) {
			low = mid + 1;
		}
		else if (values[mid] > key) {
			high = mid - 1;
		}
		
	}
	return -1;
}
}
