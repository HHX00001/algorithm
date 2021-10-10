package cn.hhx.algorithm4.shellsort;

/**
 * @author hhxStellar
 * @date 2021/10/9-22:12
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[50];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        arr = shellSort(arr);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static int[] shellSort(int[] arr) {
        //循环将增量除2
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                for (int k = j; k < arr.length - i; k += i) {
                    for (int l = k + i; l > j; l -= i) {
                        if (arr[l] < arr[l - i]) {
                            int temp = arr[l];
                            arr[l] = arr[l - i];
                            arr[l - i] = temp;
                        } else
                            break;
                    }
                }
            }
        }


        return arr;
    }
}
