package cn.hhx.algorithm8.heapsort;

/**
 * @author hhxStellar
 * @date 2021/10/16-10:40
 */
public class TestHeapSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 16000000);
        }

        long startTime = System.currentTimeMillis();
        HeapSort.heapSort(arr);
        long time = System.currentTimeMillis() - startTime;

        System.out.println(time);
    }
}
