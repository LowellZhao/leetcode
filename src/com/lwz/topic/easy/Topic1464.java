package com.lwz.topic.easy;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * @author lwz
 * @date 2022/3/14
 */
public class Topic1464 {

    public static int maxProduct(int[] nums) {
        int[] min = new int[]{0, 0};
        for (int num : nums) {
            if (num > min[0]) {
                min[1] = min[0];
                min[0] = num;
            } else if (num > min[1]) {
                min[1] = num;
            }
        }
        return (min[0] - 1) * (min[1] - 1);
    }

    public static int maxProductV2(int[] nums) {
        int max1 = 0, max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 4, 5, 2};
//        int[] nums = new int[]{1, 5, 4, 5};
        int[] nums = new int[]{3, 7};

//        int maxProduct = maxProduct(nums);
        int maxProduct = maxProductV2(nums);
        System.out.println(maxProduct);
    }

}
