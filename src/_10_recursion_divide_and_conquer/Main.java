package _10_recursion_divide_and_conquer;

import static _10_recursion_divide_and_conquer.FindMaxValue.max;
import static _10_recursion_divide_and_conquer.SumValues.sum;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {4, 2, 5, 1, 5, 3, 1, 2};
        int result = sum(arr1, 0, arr1.length - 1);
        System.out.println(result);

        int[] arr2 = {2, 1, 6, 7, 5, 8, 3, 4};
        System.out.println(max(arr2, 0, arr2.length - 1));
    }
}
