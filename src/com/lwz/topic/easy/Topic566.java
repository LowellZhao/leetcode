package com.lwz.topic.easy;

import java.util.Arrays;

public class Topic566 {

    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int line = nums[0].length;
        if (row * line != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        int ri = 0;
        int rj = 0;
        for (int[] num : nums) {
            for (int i : num) {
                res[ri][rj] = i;
                rj++;
                if (rj == c) {
                    ri++;
                    rj = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] ints = matrixReshape(nums, 2, 3);
        System.out.println(Arrays.deepToString(ints));
    }
}
