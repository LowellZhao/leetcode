package com.lwz.topic;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

    private static boolean test01(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return false;
            }
            map.put(num, 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(test01(new int[]{}));
        System.out.println(test01(new int[]{1, 2, 1}));
        System.out.println(test01(new int[]{1, 2, 3}));


        System.out.println(test02(10, new int[]{5, 3}, new int[]{500, 200}));
        System.out.println(test02(11, new int[]{5, 3, 2}, new int[]{500, 200, 100}));
    }

    //自底向上,改为非递归实现
    private static int test02(int w, int[] p, int[] g) {
        int[][] result = new int[w + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    result[i][j] = result[i - 1][j];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return result[g.length][w];
    }

}
