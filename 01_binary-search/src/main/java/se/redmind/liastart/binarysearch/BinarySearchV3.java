/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.redmind.liastart.binarysearch;

/**
 *
 * @author Julia
 */
public interface BinarySearchV3 {
    /**
     * 
     * third version I use recursion to check the key is on which side of the arrays element
     * this method is a little complicated. I take a bit more time to test code
     * @param key for search
     * @param values for the searching source
     * @return found index or -1 for out of bound
     */

    int chop3(int key, int[] values, int[] origin);

}
