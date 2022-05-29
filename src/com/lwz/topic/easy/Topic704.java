package com.lwz.topic.easy;

public class Topic704 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 4, 5, 6, 7, 8, 10};
        int search = search(nums, 7);
        System.out.println(search);

    }

}
