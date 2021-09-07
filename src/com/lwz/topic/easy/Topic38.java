package com.lwz.topic.easy;

public class Topic38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char temp = s.charAt(0);
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (c != temp) {
                sb.append(count).append(temp);
                count = 0;
                temp = c;
            }
            count++;
        }

        if (count > 0) {
            sb.append(count).append(temp);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Topic38().countAndSay(1));
        System.out.println(new Topic38().countAndSay(2));
        System.out.println(new Topic38().countAndSay(3));
        System.out.println(new Topic38().countAndSay(4));
        System.out.println(new Topic38().countAndSay(5));
        System.out.println(new Topic38().countAndSay(6));
        System.out.println(new Topic38().countAndSay(7));
        System.out.println(new Topic38().countAndSay(30));
    }

}
