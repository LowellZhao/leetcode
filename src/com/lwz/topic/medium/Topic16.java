package com.lwz.topic.medium;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Topic16 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        Integer res = null;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (res == null) {
                    res = sum;
                } else {
                    if (Math.abs(res - target) > Math.abs(sum - target)) {
                        res = sum;
                    }
                }
            }
        }

        if (res == null) {
            res = 0;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-3, -2, -5, 3, -4};
        System.out.println(threeSumClosest(nums, -1));
    }

}
