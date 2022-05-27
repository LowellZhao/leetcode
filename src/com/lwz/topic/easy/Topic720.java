package com.lwz.topic.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lwz
 * @date 2022/3/17
 */
public class Topic720 {

    public String longestWord(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        AtomicReference<String> value = new AtomicReference<>("");
        AtomicInteger maxLength = new AtomicInteger();
        Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed()).forEach(e -> {
            int length = e.length();
            if (maxLength.get() > length) {
                return;
            }
            for (int i = 0; i < e.length(); i++) {
                String substring = e.substring(0, length - i);
                if (wordMap.get(substring) == null) {
                    return;
                }
            }
            if (length >= maxLength.get() && ("".equals(value.get()) || e.compareTo(value.get()) < 0)) {
                value.set(e);
                maxLength.set(length);
            }

        });
        return value.get();
    }

    public String longestWordV2(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        String longest = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                longest = word;
            }
        }
        return longest;
    }

    public String longestWordV3(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        AtomicReference<String> value = new AtomicReference<>("");
        AtomicInteger maxLength = new AtomicInteger();
        Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed()).forEach(e -> {
            int length = e.length();
            if (maxLength.get() > length) {
                return;
            }
            for (int i = 0; i < e.length(); i++) {
                String substring = e.substring(0, length - i);
                if (!wordSet.contains(substring)) {
                    return;
                }
            }
            if (length >= maxLength.get() && ("".equals(value.get()) || e.compareTo(value.get()) < 0)) {
                value.set(e);
                maxLength.set(length);
            }

        });
        return value.get();
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"w", "wo", "wor", "worl", "world"};
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
//        String[] words = new String[]{"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast", "l", "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"};
//        String[] words = new String[]{"t", "ti", "tig", "tige", "tiger", "e", "en", "eng", "engl", "engli", "englis", "english", "h", "hi", "his", "hist", "histo", "histor", "history"};
//        String[] words = new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
//        String[] words = new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
//        String[] words = new String[]{"wo", "wor", "worl", "world"};

        String word = new Topic720().longestWord(words);
        System.out.println(word);
        String wordV2 = new Topic720().longestWordV2(words);
        System.out.println(wordV2);
        String wordV3 = new Topic720().longestWordV3(words);
        System.out.println(wordV3);
    }

}
