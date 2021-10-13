package cn.hhx.algorithm5.fibonaccisearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hhxStellar
 * @date 2021/10/12-21:53
 */
public class FibonacciSearch {
    private static ArrayList<Integer> indexList = new ArrayList<>();
    private static int[] fbnArr = getFibonacci(20);

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        fibonacciSearch(arr, 9);
        for (int elem : indexList) {
            System.out.println(elem);
        }
    }

    public static void fibonacciSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        while (arr.length > fbnArr[k] - 1) {//使fbnc数大于或等于数组的长度
            k++;
        }

        int[] temp = Arrays.copyOf(arr, fbnArr[k] - 1);//复制原数组到fbnc长度的数组，不足的用0填充

        for (int i = arr.length; i < fbnArr[k] - 1; i++) {
            temp[i] = temp[arr.length - 1];//对于fbnc数组多于原数组的部分，用原数组最后一个元素填充
        }

        while (low <= high) {
            int mid = low + fbnArr[k - 1] - 1;
            if (temp[mid] == target) {

                if (mid < high) indexList.add(mid);
                else indexList.add(high);

                return;
            } else if (target < temp[mid]) {
                high = mid - 1;
                k -= 1;
            } else {
                low = mid + 1;
                k -= 2;
            }
        }

        indexList.add(-1);

    }

    public static int[] getFibonacci(int size) {
        int[] fbnArr = new int[size];
        fbnArr[0] = 1;
        fbnArr[1] = 1;
        for (int i = 2; i < size; i++) {
            fbnArr[i] = fbnArr[i - 1] + fbnArr[i - 2];
        }
        return fbnArr;
    }
}
