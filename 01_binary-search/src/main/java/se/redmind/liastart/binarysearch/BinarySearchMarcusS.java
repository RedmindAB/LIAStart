/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */

package se.redmind.liastart.binarysearch;

import java.util.Arrays;


public class BinarySearchMarcusS implements BinarySearch{
                        
                       
    public int chop1(int key, int[] values) {
        int arrayLength = values.length;
        //arrayLenght is the amount of numbers to check
        //it is continously halved
        //my loop goes through the array while the arrayLength has more than 1 number
        int start=0;
        int end = values.length;
        while(arrayLength>0){

            int positionToSearch = start + (arrayLength/2);
            arrayLength=(end-start)/2;  

            if(values[positionToSearch]==key){
                return positionToSearch;
            }
            else if(values[positionToSearch] < key){
                if(positionToSearch==start)//when only 2 array-points are left, we must manually change search position
                    positionToSearch++;
                start=positionToSearch;
            }
            else if(values[positionToSearch] > key){
                if(positionToSearch==end)//when only 2 array-points are left, we must manually change search position
                    positionToSearch--;
                end=positionToSearch;
            }
        }
        return -1;
    }
    
    
    public int chop2(int key, int[] values) {
        int mid = values.length/2;
        
        if (values.length==0){
            return -1;
        }
        else if(values[mid] == key){
            return mid;
        }
        else if (values.length == 1){
            return -1;
        }
        else if (values[mid] < key){
            int[] array2 = Arrays.copyOfRange(values,mid,values.length);
            int a = chop2(key, array2);
            if(a==-1)
                return -1;
            else 
                return a+mid;
        }
        else if (values[mid] > key){
            int[] array2 = Arrays.copyOfRange(values,0,mid);
            return chop2(key, array2);
        }
        
        return -1;
    }
    
    public int chop3(int key, int[] values){
        int high = values.length-1;
        int low = 0;
        
        while(low <= high){
            
            int mid = (high-low)/2 + low;
            
            if(values[mid]==key){
                return mid;
            }
            if(key > values[mid]){
                low=mid+1;
            }
            else if (key < values[mid]){
                high = mid-1;
            }
        }
        return -1;
    }
    
    
    
    

    
    public int chop(int key, int[] values) {
          return -1;
      } 
    
    
    public static void main(String args[]){
        
        BinarySearchMarcusS bsm = new BinarySearchMarcusS();
        
        
        System.out.println("Now we test chop1, my first made search");
        long start = System.currentTimeMillis();
        int[] foundNumbers = new int[1000];
        for(int y=0; y<1000; y++){
            int length = (int)(Math.random()*2000);
            int[] arr = new int[length];
            int nextNumber=0;
            for(int x=0; x<length; x++){
                arr[x]=nextNumber + (int)(Math.random()*20);
                nextNumber=arr[x];
            }
            int position = (int)(Math.random()*length);
            int value = arr[position];
            int foundPosition = bsm.chop1(value, arr);
            foundNumbers[y]=foundPosition;
        }
        long end = System.currentTimeMillis(); 
        System.out.println("Performing my chop1 method 1000 times takes " + 
                                    (end - start) + "ms"); 
        
        
        System.out.println("Now we test chop2, my second made search");
         start = System.currentTimeMillis();
        foundNumbers = new int[1000];
        for(int y=0; y<1000; y++){
            int length = (int)(Math.random()*2000);
            int[] arr = new int[length];
            int nextNumber=0;
            for(int x=0; x<length; x++){
                arr[x]=nextNumber + (int)(Math.random()*20);
                nextNumber=arr[x];
            }
            int position = (int)(Math.random()*length);
            int value = arr[position];
            int foundPosition = bsm.chop2(value, arr);
            foundNumbers[y]=foundPosition;
        }
         end = System.currentTimeMillis(); 
        System.out.println("Performing my chop2 method 1000 times takes " + 
                                    (end - start) + "ms"); 
        
        
        System.out.println("Now we test chop3, my third made search");
         start = System.currentTimeMillis();
        foundNumbers = new int[1000];
        for(int y=0; y<1000; y++){
            int length = (int)(Math.random()*2000);
            int[] arr = new int[length];
            int nextNumber=0;
            for(int x=0; x<length; x++){
                arr[x]=nextNumber + (int)(Math.random()*20);
                nextNumber=arr[x];
            }
            int position = (int)(Math.random()*length);
            int value = arr[position];
            int foundPosition = bsm.chop3(value, arr);
            foundNumbers[y]=foundPosition;
        }
         end = System.currentTimeMillis(); 
        System.out.println("Performing my chop3 method 100000 times takes " + 
                                    (end - start) + "ms"); 
    }
    
}
