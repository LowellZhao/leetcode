package com.lwz.topic;

public class Topic07 {

    private static int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        int[] xx = new int[12];
        int temp = x;
        int index = 0;
        while (temp != 0) {
            xx[index++] = temp % 10;
            temp = temp / 10;
        }

        int temp2 = 0;
        int index2 = 0;
        while (index != index2) {
//            System.out.println(temp2);
            if (temp2 > 214748364) {
                return 0;
            }
            temp2 = (temp2 * 10) + xx[index2++];
        }
        if (temp2 < 0) {
            return 0;
        }

        if (flag) {
            return -temp2;
        }

        return temp2;
    }

    private static int reverse2(int x) {
        int temp = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            temp = (temp * 10) + pop;
        }
        return temp;
    }

    public static void main(String[] args) {
//        int maxValue = Integer.MAX_VALUE;
//        System.out.println(maxValue);

//        System.out.println(reverse(-214748364));
//        System.out.println(reverse(1534236469));
//        System.out.println(reverse(1534236469));
//        System.out.println(reverse(-2147483648));
//        System.out.println(reverse(-2147483647));

//        System.out.println(reverse2(-2147483648));
        System.out.println(reverse2(1534236469));
    }
}
