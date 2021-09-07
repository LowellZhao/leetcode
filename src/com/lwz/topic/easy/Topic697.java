package com.lwz.topic.easy;

import java.util.HashMap;
import java.util.Map;

public class Topic697 {

    private static int findShortestSubArray(int[] nums) {
        int length = nums.length;
        int[] start = new int[50000];
        int[] end = new int[50000];
        int[] num = new int[50000];
        int max = 0;
        int maxNum = -1;
        int min = 1;

        int a;
        int b;

        for (int i = 0; i < length; i++) {
            int num1 = nums[i];
            if (num[num1] == 0) {
                start[num1] = i;
                end[num1] = i;
                num[num1]++;
            } else {
                end[num1] = i;
                num[num1]++;
                if (num[num1] > max) {
                    min = end[num1] - start[num1] + 1;
                    max = num[num1];
                    maxNum = num1;
                } else if (num[num1] == max) {
                    a = end[num1] - start[num1] + 1;
                    b = end[maxNum] - start[maxNum] + 1;
                    if (a <= b) {
                        min = a;
                        max = num[num1];
                        maxNum = num1;
                    }
                }
            }
        }
        return min;
    }

    private static int findShortestSubArrayV2(int[] nums) {
        int length = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        int max = 0;
        int maxNum = -1;
        int min = 1;

        int a;
        int b;

        for (int i = 0; i < length; i++) {
            int num1 = nums[i];
            int[] ints = map.get(num1);
            if (ints == null) {
                map.put(num1, new int[]{1, i, i});
            } else {
                ints[0]++;
                ints[2] = i;

                if (ints[0] > max) {
                    min = ints[2] - ints[1] + 1;
                    max = ints[0];
                    maxNum = num1;
                } else if (ints[0] == max) {
                    a = ints[2] - ints[1] + 1;
                    int[] ints1 = map.get(maxNum);
                    b = ints1[2] - ints1[1] + 1;
                    if (a <= b) {
                        min = a;
                        maxNum = num1;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 2, 3, 1};
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
//        int shortestSubArray = findShortestSubArray(nums);
        int shortestSubArray = findShortestSubArrayV2(nums);
        System.out.println(shortestSubArray);
    }

}
