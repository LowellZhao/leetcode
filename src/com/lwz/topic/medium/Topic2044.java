package com.lwz.topic.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date 2022/3/15
 */
public class Topic2044 {

    private int max;

    public int countMaxOrSubsets(int[] nums) {
        max = -1;

        int[] res = new int[nums.length];
        Map<Integer, Integer> resMap = new HashMap<>();
        some(nums, 0, 0, res, resMap);
        return resMap.getOrDefault(max, 0);
    }

    public void some(int[] nums, int index, int current, int[] res, Map<Integer, Integer> resMap) {
        if (index == nums.length) {
            int result = 0;
            for (int i = 0; i < current; i++) {
                result = res[i] | result;
            }
            if (result > max) {
                max = result;
            }
            Integer nowCount = resMap.getOrDefault(result, 0);
            resMap.put(result, nowCount + 1);
            return;
        }

        some(nums, index + 1, current, res, resMap);
        res[current] = nums[index];
        some(nums, index + 1, current + 1, res, resMap);
    }

    private int resCount;

    public int countMaxOrSubsetsV2(int[] nums) {
        max = -1;
        resCount = 0;
        someV2(nums, 0, 0);
        return resCount;
    }

    public void someV2(int[] nums, int index, int current) {
        if (index == nums.length) {
            if (current > max) {
                max = current;
                resCount = 1;
                return;
            }
            if (current == max) {
                resCount++;
            }
            return;
        }
        someV2(nums, index + 1, current);
        someV2(nums, index + 1, current | nums[index]);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 1};
        int[] nums = new int[]{2, 2, 2};
//        int[] nums = new int[]{3, 2, 1, 5};

        System.out.println(new Topic2044().countMaxOrSubsets(nums));
        System.out.println(new Topic2044().countMaxOrSubsetsV2(nums));
    }

}
