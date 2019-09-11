
package se.redmind.liastart.binarysearch;


public class BinarySearchIterative implements BinarySearch {

    public int chop(int key, int[] values){
        int left = 0;
        int right = values.length - 1;
        
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            
            if (values[middle] == key){
                return middle;
            }
            
            if (values[middle] > key){
                right = middle - 1;
            }
            
            else 
                left = middle + 1;
        }

        return -1;
    }

}


//int binarySearch(int arr[], int x) 
//    { 
//        int l = 0, r = arr.length - 1; 
//        while (l <= r) { 
//            int m = l + (r - l) / 2; 
//  
//            // Check if x is present at mid 
//            if (arr[m] == x) 
//                return m; 
//  
//            // If x greater, ignore left half 
//            if (arr[m] < x) 
//                l = m + 1; 
//  
//            // If x is smaller, ignore right half 
//            else
//                r = m - 1; 
//        } 
//  
//        // if we reach here, then element was 
//        // not present 
//        return -1; 
//    } 
