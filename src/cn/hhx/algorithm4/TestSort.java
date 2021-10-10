package cn.hhx.algorithm4;

import cn.hhx.algorithm4.bubblesort.BubbleSort;
import cn.hhx.algorithm4.bucketsort.BucketSort;
import cn.hhx.algorithm4.insertionsort.InsertionSort;
import cn.hhx.algorithm4.mergesort.MergeSort;
import cn.hhx.algorithm4.quicksort.QuickSort;
import cn.hhx.algorithm4.selectionsort.SelectionSort;
import cn.hhx.algorithm4.shellsort.ShellSort;
import org.junit.Test;
import sun.misc.GC;


/**
 * @author hhxStellar
 * @date 2021/10/9-22:03
 */
public class TestSort {
    @Test
    public void test() {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
//            arr[i] = 60000 - i;
        }

        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();
        int[] arr6 = arr.clone();
        int[] arr7 = arr.clone();

//        long startTime = System.currentTimeMillis();
//        arr1 = BubbleSort.bubbleSort(arr1);
//        long time = System.currentTimeMillis() - startTime;
//
//        long startTime1 = System.currentTimeMillis();
//        arr2 = SelectionSort.selectionSort(arr2);
//        long time1 = System.currentTimeMillis() - startTime1;

//        long startTime2 = System.currentTimeMillis();
//        arr3 = InsertionSort.insertionSort(arr3);
//        long time2 = System.currentTimeMillis() - startTime2;

        long startTime3 = System.currentTimeMillis();
        arr4 = ShellSort.shellSort(arr4);
        long time3 = System.currentTimeMillis() - startTime3;

        long startTime4 = System.currentTimeMillis();
        QuickSort.quickSort(arr5, 0, arr5.length - 1);
        long time4 = System.currentTimeMillis() - startTime4;

        long startTime5 = System.currentTimeMillis();
        MergeSort.mergeSort(arr6, 0, arr6.length - 1);
        long time5 = System.currentTimeMillis() - startTime5;

        long startTime6 = System.currentTimeMillis();
        BucketSort.BucketSort(arr7);
        long time6 = System.currentTimeMillis() - startTime6;

        System.out.println("冒泡排序：" + "time" + " 选择排序：" + "time1 " + " 插入排序：" + "time2" + " 希尔排序：" + time3 + " 快速排序：" + time4
                + " 归并排序：" + time5 + " 桶排序：" + time6);

    }

}
