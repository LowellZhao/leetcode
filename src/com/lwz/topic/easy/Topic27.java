package com.lwz.topic.easy;

import java.util.Arrays;

public class Topic27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        int i = new Topic27().removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}
