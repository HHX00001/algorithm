package cn.hhx.algorithm4.selectionsort;

/**
 * @author hhxStellar
 * @date 2021/10/9-21:00
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 500);
        }


        arr = selectionSort(arr);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }


    public static int[] selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
