package se.redmind.liastart.binarysearch;

public class BinarySearchRecursive implements BinarySearch {

    public int chop(int key, int[] values) {
        int left = 0;
        int right = 0;
        
        if (values.length > 0){
            right = values.length - 1;
        }
        
        return chopRecursive(key, values, left, right);
    }

    public int chopRecursive(int key, int[] values, int left, int right) {

        int middle = (right - left) / 2 + left;
        
        if (values.length == 0){
            System.out.println("empty array");
            return -1;
        }
        
        if (right < left){
            return -1;
        }
        
        if (key < values[middle]){
            return chopRecursive(key, values, left, right-1);
        }
        
        if (key > values[middle]){
            return chopRecursive(key, values, left+1, right);
        }
        
        if (key == values[middle]){
            return middle;
        }
        
        return -1;

    }
}
