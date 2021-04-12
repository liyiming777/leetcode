package com.lym.package01;

import java.util.HashSet;
import java.util.Set;

public class Jianzhi48 {
    //剑指 Offer 48. 最长不含重复字符的子字符串
    public int lengthOfLongestSubstring(String s) {
        Set<Character> help = new HashSet<>();
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            while (help.contains(temp)) {
                help.remove(s.charAt(index++));
            }
            help.add(temp);
            max = Math.max(max, help.size());
        }
        return max;
    }
}
