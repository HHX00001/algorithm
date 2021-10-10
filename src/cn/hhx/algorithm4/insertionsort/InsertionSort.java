package cn.hhx.algorithm4.insertionsort;

/**
 * @author hhxStellar
 * @date 2021/10/9-21:26
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        arr = insertionSort(arr);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else
                    break;
            }
        }

        return arr;
    }
}
