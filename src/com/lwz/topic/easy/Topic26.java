package com.lwz.topic.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Topic26 {

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (map.get(num) == null) {
                temp[index] = num;
                index++;
                map.put(num, 1);
            }
            System.out.println(Arrays.toString(temp));
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        return index;
    }

    public int removeDuplicatesV2(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int i = new Topic26().removeDuplicatesV2(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}
