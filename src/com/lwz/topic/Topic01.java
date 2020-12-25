package com.lwz.topic;

import java.util.HashMap;
import java.util.Map;

public class Topic01 {

    public static int[] toSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = toSum(nums, target);
        if (ints != null) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

}
