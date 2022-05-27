package com.lwz.topic.difficulty;

/**
 * @author
 * @date 2022/3/16
 */
public class Topic432 {

    static class AllOne {

        public AllOne() {

        }

        public void inc(String key) {

        }

        public void dec(String key) {

        }

        public String getMaxKey() {
            return null;
        }

        public String getMinKey() {
            return null;
        }
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.getMaxKey(); // 返回 "hello"
        allOne.getMinKey(); // 返回 "hello"
        allOne.inc("leet");
        allOne.getMaxKey(); // 返回 "hello"
        allOne.getMinKey(); // 返回 "leet"
    }

}
