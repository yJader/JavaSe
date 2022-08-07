package arrays_;

import java.util.Arrays;

public class ArraysMethod {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 1, 2, 3};
        //binarySearch
        Integer[] arr1 = arr;
        Arrays.sort(arr1);
        System.out.println(Arrays.binarySearch(arr, 10));
        //copyOf
        Integer[] arr2 = Arrays.copyOf(arr, arr.length + 3);
        System.out.println(Arrays.toString(arr2));
        try{
            Arrays.copyOf(arr, -1);
        } catch (Exception NegativeArraySizeException) {
            System.out.println("发生NegativeArraySizeException异常");
        }

        //
    }
}
