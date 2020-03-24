package com.smartcloud.common.leetCode.practice.string;


import org.apache.commons.lang.StringUtils;

/**
 * 判断两个字符串是否互为变形词
 * 变形词：长度相同，顺序不同，出现的字符相同
 * Created by znq on 2018/3/7.
 */
public class StringJuge {

    static Boolean isDeformation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return Boolean.FALSE;
        }
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int[] map = new int[256];

        for (int i = 0; i < a.length; i++) {
            map[a[i]]++;
        }

        for (int j = 0; j < map.length; j++) {
            System.out.println(map[j]);
        }
        return Boolean.FALSE;
    }

    /**
     * 字符串中数字字串的求和
     *
     * @param s
     * @return
     */
    public static int numsum(String s) {
        if (!StringUtils.isNotBlank(s))
            throw new NullPointerException();
        char[] a = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] < 9) {
                sum += a[i];
            }

        }

        return sum;
    }

    public static void main(String[] args) {
//        isDeformation("anbdf", "dfdfu");
        System.out.println(numsum("ere4ere45"));
    }
}
