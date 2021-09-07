package com.lwz.topic.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Topic20 {

    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0 || length % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (deque.isEmpty() || deque.peek() != pairs.get(c)) {
                    return false;
                }
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String c = "()[]{}";
        System.out.println(new Topic20().isValid(c));
        String c2 = "([)]";
        System.out.println(new Topic20().isValid(c2));
    }

}
