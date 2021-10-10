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
        //循环将增量除以2
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //按照增量分组，记录每组的开头
            for (int j = 0; j < i; j++) {
                //每组前k+1个元素为有序表,k为每组有序表中最后一个元素的索引
                for (int k = j; k < arr.length - i; k += i) {
                    //每组有序元素表的后一个元素开始跟有序表排序，从后向前插入
                    for (int l = k + i; l > j; l -= i) {
                        if (arr[l] < arr[l - i]) {
                            int temp = arr[l];
                            arr[l] = arr[l - i];
                            arr[l - i] = temp;
                        }
                        else
                            break;
                    }
                }
            }
        }
        return arr;
    }
}
