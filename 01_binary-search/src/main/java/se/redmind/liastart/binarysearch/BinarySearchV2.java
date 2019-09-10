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
     * second version I change to use index to check which side is the key located
     * I got this method from mob programming, the code is simple and smart !
     * @param key for search
     * @param values for the searching source
     * @return found index or -1 for out of bound
     */
        int chop(int key, int[] values);

    
}
