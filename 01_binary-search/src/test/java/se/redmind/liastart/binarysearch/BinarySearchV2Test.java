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
public class BinarySearchV2Test {
    
    private BinarySearchV2 search = new BinarySearchV2() {
        public int chop(int key, int[] values) {            
            int found = -1;
            if(values.length>0){
                Arrays.sort(values);
                for(int i=0; i<values.length; i++){
                    if(key == values[i]){
                        found = i;
                        break;
                    }
                }
                
            }
            return found;
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
