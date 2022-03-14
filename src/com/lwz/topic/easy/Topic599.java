package com.lwz.topic.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 *
 * @author lwz
 * @date 2022/3/14
 */
public class Topic599 {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int now = i + j;
                    if (now < min) {
                        res.clear();
                        res.add(list1[i]);
                        min = now;
                    } else if (now == min) {
                        res.add(list1[i]);
                    }
                }
            }
        }
        return res.toArray(new String[0]);
    }

    public static String[] findRestaurantV2(String[] list1, String[] list2) {
        int size = (int) (list1.length / 0.75 + 1);
        Map<String, Integer> list1Map = new HashMap<>(size);
        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            Integer list1Index = list1Map.get(list2[i]);
            if (list1Index != null) {
                if (i + list1Index < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = i + list1Index;
                } else if (i + list1Index == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
//        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};

//        String[] restaurant = findRestaurant(list1, list2);
        String[] restaurant = findRestaurantV2(list1, list2);
        System.out.println(Arrays.toString(restaurant));

    }

}
