package cn.hhx.leetcode;

/**
 * @author hhxStellar
 * @date 2021/10/14-16:30
 */
public class Test {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{}, new int[]{1});
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] newArr = new int[length3];

        for (int i = 0, j = 0, k = 0; i < length3 && j < length1 && k < length2; i++) {
            if (nums1[j] < nums2[k]) {
                newArr[i] = nums1[j];
                j++;
            } else {
                newArr[i] = nums2[k];
                k++;
            }

            if (j == length1) {
                i++;
                while (i < length3) {
                    newArr[i++] = nums2[k++];
                }
            } else if (k == length2) {
                i++;
                while (i < length3) {
                    newArr[i++] = nums1[j++];
                }
            }
        }

        if (length3 % 2 == 0)
            return (newArr[length3 / 2] + newArr[length3 / 2 - 1] + 0.0) / 2;
        else
            return newArr[length3 / 2] + 0.0;
    }
}
