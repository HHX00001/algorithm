package cn.hhx.algorithm4.quicksort;


/**
 * @author hhxStellar
 * @date 2021/10/10-11:11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
//        int r = right;
//        int l = left;
//        int pivot = arr[left];
//        while (l < r) {
//            while (arr[r] >= pivot && l < r) r--;
//            while (arr[l] <= pivot && l < r) l++;
//            if (l < r) swap(arr, l, r);
//        }
//        swap(arr, left, l);
//
//        return l;

        int pivot = arr[left];
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
