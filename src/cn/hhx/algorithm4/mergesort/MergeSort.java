package cn.hhx.algorithm4.mergesort;

/**
 * @author hhxStellar
 * @date 2021/10/10-17:36
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, right, mid);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1, t = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }

        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }

        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }

        for (int elem : temp) {
            arr[left] = elem;
            left++;
        }
    }
}
