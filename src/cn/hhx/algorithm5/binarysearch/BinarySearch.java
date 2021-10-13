package cn.hhx.algorithm5.binarysearch;

import java.util.ArrayList;

/**
 * 二分查找
 *
 * @author hhxStellar
 * @date 2021/10/12-20:28
 */
public class BinarySearch {
    private static ArrayList<Integer> indexList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        arr[2] = 5;
        arr[6] = 5;

        int n = 5;
        binarySearch(arr, 0, arr.length - 1, n);
        int index1 = binarySearch(arr, n);
        for (int elem : indexList) {
            System.out.println(elem);
        }
//        System.out.println(index1);
    }

    //递归查找相同数的个数
    public static void binarySearch(int[] arr, int left, int right, int n) {
        if (left > right)
            return;

        int mid = (left + right) / 2;
        if (arr[mid] == n) indexList.add(mid);
        binarySearch(arr, mid + 1, right, n);
        binarySearch(arr, left, mid - 1, n);

    }

    //非递归查找某一个数
    public static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        int index = -1;
        while (left <= right) {
            if (arr[mid] == n) {
                index = mid;
                break;
            } else if (arr[mid] > n) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return index;
    }
}
