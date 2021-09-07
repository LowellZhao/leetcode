package com.lwz.topic.easy;

public class Topic35 {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(new Topic35().searchInsert(nums, 5));
        System.out.println(new Topic35().searchInsert(nums, 2));
        System.out.println(new Topic35().searchInsert(nums, 7));
        System.out.println(new Topic35().searchInsert(nums, 0));
    }

}
