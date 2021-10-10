package cn.hhx.algorithm4.bucketsort;

/**
 * @author hhxStellar
 * @date 2021/10/10-18:48
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[5000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        BucketSort(arr);

        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static void BucketSort(int[] arr) {
        int max = 0;
        for (int elem : arr) {
            if (elem > max)
                max = elem;
        }
        int[][] bucket = new int[10][arr.length];
        int[] bucketElemCount = new int[10];

        int maxLength = (max + "").length();

        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {

            for (int i = 0; i < arr.length; i++) {
                int digitOfElem = arr[i] / n % 10;
                bucket[digitOfElem][bucketElemCount[digitOfElem]] = arr[i];
                bucketElemCount[digitOfElem]++;
            }

            int index = 0;
            for (int i = 0; i < bucketElemCount.length; i++) {
                if (bucketElemCount[i] != 0) {
                    for (int j = 0; j < bucketElemCount[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                bucketElemCount[i] = 0;
            }
        }


    }
}
