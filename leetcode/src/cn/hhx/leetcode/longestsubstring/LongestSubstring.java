package cn.hhx.leetcode.longestsubstring;


import java.util.*;

/**
 * @author hhxStellar
 * @date 2021/10/4-23:28
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "aaaaaba";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == "") {
            return 0;
        }
        char[] chars = s.toCharArray();
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (set.add((int) chars[j]) == false || j == chars.length - 1) {
                    countList.add(set.size());
                    break;
                }
            }
        }

        int max = 0;
        for (Integer n : countList) {
            if (n > max)
                max = n;
        }

        return max;
    }
}
