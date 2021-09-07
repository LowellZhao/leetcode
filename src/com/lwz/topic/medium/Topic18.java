package com.lwz.topic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/solution/si-shu-zhi-he-by-leetcode-solution/
 */
public class Topic18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        Integer res = null;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }

}
