package week_2.module_003_simple_sorts;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] unsorted_1 = {5, 6, 3, 6, 2, 4, 1, 6, 8, 2, 7, 5, 2, 7, 4, 3, 9};
        int[] unsorted_2 = {5, 6, 3, 6, 2, 4, 1, 6, 8, 2, 7, 5, 2, 7, 4, 3, 9};
        int[] unsorted_3 = {5, 6, 3, 6, 2, 4, 1, 6, 8, 2, 7, 5, 2, 7, 4, 3, 9};

        bubblesort(unsorted_1);
        selectionsort(unsorted_2);
        insertionsort(unsorted_3);

        System.out.println(Arrays.toString(unsorted_1));
        System.out.println(Arrays.toString(unsorted_2));
        System.out.println(Arrays.toString(unsorted_3));
    }

    //simple sorting algorithms include bubblesort, selection sort, and insertion sort

    //just a simple swap -- this is a common utility in many sorting algorithms
    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //bublesort works off of swapping every out-of-place item in the list
    //it runs in O(n^2) time
    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            //we can follow the triangular pattern, because we
            //know that the last one that we altered is
            //guaranteed to be in its proper place
            for (int j = 0; j < arr.length - i - 1; j++) {

                //if they're out of order, swap them
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    public static void selectionsort(int[] arr) {
        //start at the back, and grab the biggest number,
        //moving it directly to its proper place
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[i];
            int position = i;

            for (int j = 0; j < i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    position = j;
                }
            }

            //now swap it
            swap(i, position, arr);
        }
    }

    //insertion sort is the only simple sort we care about
    //because it has a nice Omega(n), otherwise it is also
    //clearly O(n^2)
    public static void insertionsort(int[] arr) {
        //start at the beginning of the list and inch towards
        //the end, inserting the new element at the right place
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(j, j - 1, arr);
            }
        }
    }
}
