package com.lwz.topic.medium;

import java.util.ArrayList;
import java.util.List;

public class Topic78 {

    private static List<Integer> t = new ArrayList<>();
    private static List<List<Integer>> ans = new ArrayList<>();

    private static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {

        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

    }

}
