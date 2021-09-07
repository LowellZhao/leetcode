package com.lwz.topic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class Topic15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if ((i > 0 && num == nums[i - 1]) || num > 0) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int sum = num + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> integers = Arrays.asList(num, nums[left], nums[right]);
                    result.add(integers);
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {0, 0, 0};
        int[] nums = {0};
//        int[] nums = {};
        System.out.println(threeSum(nums));
    }

}
