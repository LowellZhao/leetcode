package com.lwz.topic.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwz
 * @since 2022/9/19
 */
public class Topic1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer iCount = map.get(nums[i]);
                Integer jCount = map.get(nums[j]);
                if (iCount > jCount || (jCount.equals(iCount) && nums[j] > nums[i])) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public int[] frequencySort2(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
//        int[] frequencySort = new Topic1636().frequencySort(nums);
//        int[] nums = new int[]{2,3,1,3,2};
//        int[] frequencySort = new Topic1636().frequencySort(nums);
        int[] nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] frequencySort = new Topic1636().frequencySort(nums);
        System.out.println(Arrays.toString(frequencySort));
    }

}
