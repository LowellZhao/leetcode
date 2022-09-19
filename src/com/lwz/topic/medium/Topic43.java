package com.lwz.topic.medium;

/**
 * @author lwz
 * @since 2022/9/19
 */
public class Topic43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            a[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            b[i] = num2.charAt(i) - '0';
        }
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                c[i + j + 1] += a[i] * b[j];
            }
        }
        for (int i = c.length - 1; i > 0; i--) {
            int temp = c[i] / 10;
            c[i - 1] = c[i - 1] + temp;
            c[i] = c[i] % 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int value : c) {
            if (flag || value != 0) {
                stringBuilder.append(value);
                flag = true;
            }
        }
        return stringBuilder.toString();
    }

    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] c = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                c[i + j + 1] += a * b;
            }
        }
        for (int i = c.length - 1; i > 0; i--) {
            c[i - 1] = c[i - 1] + (c[i] / 10);
            c[i] = c[i] % 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int value : c) {
            if (flag || value != 0) {
                stringBuilder.append(value);
                flag = true;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        String multiply = new Topic43().multiply("2", "3");
//        String multiply = new Topic43().multiply("123", "456");
        String multiply = new Topic43().multiply2("123", "456");
//        String multiply = new Topic43().multiply("99", "99");
//        String multiply = new Topic43().multiply("2", "3");
        System.out.println(multiply);
    }

}
