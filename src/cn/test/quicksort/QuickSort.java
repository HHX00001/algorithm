package cn.test.quicksort;

import java.util.Arrays;

/**
 * @author hhxStellar
 * @date 2021/10/16-11:31
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int base = arr[left];
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= base) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, --index);
        return index;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
