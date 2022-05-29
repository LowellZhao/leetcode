package com.lwz.topic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class Topic15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            if ((i > 0 && num == nums[i - 1]) || num > 0) {
                continue;
            }

            int right = length - 1;

            for (int left = i + 1; left < length; left++) {
                int num2 = nums[left];
                if ((left > i + 1 && num2 == nums[left - 1]) || num2 > 0) {
                    continue;
                }
                while (left < right && nums[left] + nums[right] > -num) {
                    right--;
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

    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

//        int[] height = new int[]{-1, 0, 1, 2, -1, -4};
        int[] height = new int[]{0, 0, 0, 0};
//        int[] height = new int[]{-1, 0, 1};
//        int[] height = new int[]{};
        List<List<Integer>> lists = threeSum(height);
//        List<List<Integer>> lists = threeSum2(height);
        System.out.println(lists);

    }

}
