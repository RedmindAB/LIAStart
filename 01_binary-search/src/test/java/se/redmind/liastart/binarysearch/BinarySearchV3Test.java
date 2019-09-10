/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.redmind.liastart.binarysearch;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Julia
 */
public class BinarySearchV3Test {

    private BinarySearchV3 search = new BinarySearchV3() {
        public int chop3(int key, int[] values, int[] origin) {
            int found = -1;
            if (values.length > 0) {
                Arrays.sort(values);
                Arrays.sort(origin);
                if (values.length == 1) {
                    if (key == values[0]) {
                        for (int k = 0; k < origin.length; k++) {
                            if (key == origin[k]) {
                                return k;
                            }
                        }
                    } else {
                        return -1;
                    }
                }
                int half = values.length / 2;
                if (key < values[half - 1]) {
                    if (half == 1) {
                        return -1;
                    }
                    half = half / 2;
                    int[] valuesNew = new int[half];
                    for (int i = 0; i < half; i++) {
                        valuesNew[i] = values[i];
                    }
                    found = chop3(key, valuesNew, origin);
                }
                if (key == values[half - 1]) {
                    for (int k = 0; k < origin.length; k++) {
                        if (key == origin[k]) {
                            return k;
                        }
                    }
                }
                if (key > values[half - 1]) {
                    int rest = values.length - half;
                    int[] valuesNew = new int[rest];
                    for (int i = half, j = 0; i < values.length && j < rest; i++, j++) {
                        valuesNew[j] = values[i];
                    }
                    found = chop3(key, valuesNew, origin);
                }

            }
            return found;

        }
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
        int[] origin = values;

        return search.chop3(key, values, origin);
//        if (keyout == -1) {
//            return -1;
//        }
//        Arrays.sort(origin);
//        for (int k = 0; k < origin.length; k++) {
//
//            if (keyout == origin[k]) {
//                return k;
//
//            }
//        }
//
//        return keyout;
    }

}
