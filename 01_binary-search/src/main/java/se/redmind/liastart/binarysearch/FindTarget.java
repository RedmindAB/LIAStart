package se.redmind.liastart.binarysearch;

public class FindTarget implements BinarySearch {

    public int chop(int key, int[] values) {

        int start = 0;
        int end = values.length - 1;
        int mid;

        while (start <= end) {

            mid = (start + end) / 2;

            if (key > values[mid]) {
                start = mid + 1;
                System.out.println("Checking upper half. values[mid] is " + values[mid]);
            } else if (key == values[mid]) {
                System.out.println("Target exists! values[mid] is: " + values[mid]);
                return values[mid];
            } else {
                end = mid - 1;
                System.out.println("Checking lower half. values[mid] is " + values[mid]);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTarget ft = new FindTarget();

        int key = 103;
        int[] values = {5, 9, 14, 22, 40, 51, 66, 103};

        ft.chop(key, values);
    }

}
