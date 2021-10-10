package cn.hhx.algorithm4.bubblesort;

/**
 * @author hhxStellar
 * @date 2021/10/9-20:13
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[50];

        for (int i = 0; i < 50; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        arr = bubbleSort(arr);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }


    }

    public static int[] bubbleSort(int[] arr) {

        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            //设置是否有交换的标识，默认没有交换
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //有交换的时候置为false
                    flag = false;
                }
            }
//            System.out.println("-----第" + (i + 1) + "趟排序后-----");
//            for (int temp : arr)
//                System.out.print(temp + " ");
//            System.out.println();

//            //如果某一趟交换后，发现这一趟没有发生交换，则标志已经有序，直接结束循环

            if (flag == true)
                break;
        }

        return arr;
    }
}
