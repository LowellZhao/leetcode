package com.lwz.topic.easy;

import java.util.HashMap;

public class Topic860 {

    public static boolean lemonadeChange(int[] bills) {
        int length = bills.length;
        if (length == 0) {
            return true;
        }
        int fiveNum = 0;
        int tenNum = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveNum++;
                continue;
            }

            if (fiveNum < 1) {
                return false;
            }
            fiveNum--;

            if (bill == 10) {
                tenNum++;
                continue;
            }

            if (tenNum < 1) {
                if (fiveNum < 2) {
                    return false;
                } else {
                    fiveNum -= 2;
                }
            } else {
                tenNum--;
            }
        }

        return true;
    }

    private static boolean lemonadeChange2(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            map.put(bill, map.getOrDefault(bill, 0) + 1);
            int re = bill - 5;
            while (re > 0) {
                int old = re;
                if (re >= 15) {
                    Integer count = map.getOrDefault(10, 0);
                    if (count > 0) {
                        map.put(10, map.get(10) - 1);
                        re -= 10;
                    }
                }
                if (re >= 5) {
                    Integer five = map.getOrDefault(5, 0);
                    if (five > 0) {
                        map.put(5, map.get(5) - 1);
                        re -= 5;
                    }
                }
                if (re == old) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        boolean b = lemonadeChange(bills);
        System.out.println(b);

        System.out.println(lemonadeChange2(bills));
    }

}
