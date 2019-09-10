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
public interface BinarySearchV2 {
    /**
     * second version I use for loop to check the key is equal arrays element
     * this method needs to think out index out of bound exception
     * @param key for search
     * @param values for the searching source
     * @return found index or -1 for out of bound
     */
        int chop(int key, int[] values);

    
}
