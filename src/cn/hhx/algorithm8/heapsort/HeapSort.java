package cn.hhx.algorithm8.heapsort;

import java.util.Arrays;

/**
 * @author hhxStellar
 * @date 2021/10/15-21:21
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,3,2,8,11};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {
        consHeap(arr);
        for (int i = arr.length; i > 0; i--) {
            swap(arr, 0, i - 1);
            adjustHeap(arr, 0, i - 1);
        }

    }

    private static void consHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    //将非叶子节点i作为根对应的树调整成大顶堆
    private static void adjustHeap(int[] arr, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIndex = i;

        if (left < length && arr[maxIndex] < arr[left]) {
            maxIndex = left;
        }

        if (right < length && arr[maxIndex] < arr[right]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            adjustHeap(arr, maxIndex, length);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
