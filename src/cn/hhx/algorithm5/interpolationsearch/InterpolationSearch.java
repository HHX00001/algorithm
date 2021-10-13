package cn.hhx.algorithm5.interpolationsearch;

import java.util.ArrayList;

/**
 * @author hhxStellar
 * @date 2021/10/12-21:31
 */
public class InterpolationSearch {

    private static ArrayList<Integer> indexList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        int n = 9;
        interpolationSearch(arr, 0, arr.length - 1, n);

        for (int elem : indexList) {
            System.out.print(elem + " ");
        }
    }

    public static void interpolationSearch(int[] arr, int left, int right, int n) {
        if (left > right || arr[left] > n || arr[right] < n)//||后面的都是附加条件
            return;

        int mid = left + (right - left) * (n - arr[left]) / (arr[right] - arr[left]);//差值查找在二分查找的基础上改变mid的公式
        if (arr[mid] == n) indexList.add(mid);
        interpolationSearch(arr, mid + 1, right, n);
        interpolationSearch(arr, left, mid - 1, n);
    }
}
