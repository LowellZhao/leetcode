package com.lwz.topic;

import java.util.LinkedList;
import java.util.Queue;

public class Topic135 {

    public static int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        int[] res = new int[length];

        boolean up = ratings[1] > ratings[0];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < length; i++) {
            // 当前是上升
            if (up) {
                if (ratings[i] <= ratings[i - 1]) {
                    up = false;
                    res[i - 1] = -1;
                    queue.add(i - 1);
                }
            } else {
                if (ratings[i] >= ratings[i - 1]) {
                    up = true;
                    res[i - 1] = 1;
                    queue.add(i - 1);
                }
            }
        }
        // 单调
        if (queue.isEmpty()) {
            int sum = 0;
            for (int i = 1; i <= length; i++) {
                sum += i;
            }
            return sum;
        }

        while (queue.isEmpty()) {
            int i = queue.poll().intValue();
            int re = res[i];

        }


        return 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 5, 4, 5, 6, 2, 1, 2, 3};

        System.out.println(candy(a));
    }

}
